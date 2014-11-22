package org.pvytykac.creational.singleton;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CyclicBarrier;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SingletonTest {

    @Test
    public void singletonTest(){
        EagerThreadSafeSingleton s1 = EagerThreadSafeSingleton.getInstance();
        LazyNonThreadSafeSingleton s2 = LazyNonThreadSafeSingleton.getInstance();
        LazyThreadSafeSyncBlockSingleton s3 = LazyThreadSafeSyncBlockSingleton.getInstance();
        LazyThreadSafeSynchronizedSingleton s4 = LazyThreadSafeSynchronizedSingleton.getInstance();

        assertNotNull(s1);
        assertNotNull(s2);
        assertNotNull(s3);
        assertNotNull(s4);

        assertTrue(s1 == EagerThreadSafeSingleton.getInstance());
        assertTrue(s2 == LazyNonThreadSafeSingleton.getInstance());
        assertTrue(s3 == LazyThreadSafeSyncBlockSingleton.getInstance());
        assertTrue(s4 == LazyThreadSafeSynchronizedSingleton.getInstance());
    }

    @Test
    public void multithreadedSingletonTest(){
        final int threadCount = 100;
        Map<Class,Long> map = new HashMap<>();
        Class[] arr = new Class[]{
                LazyThreadSafeSynchronizedSingleton.class,
                LazyThreadSafeSyncBlockSingleton.class,
                EagerThreadSafeSingleton.class,
        };

        CyclicBarrier gate = new CyclicBarrier(threadCount + 1);
        List<Thread> liThread = new ArrayList<>();
        for(Class clazz: arr){
            try{
                liThread.clear();
                gate.reset();

                // start all the threads
               for(int i = 0; i < threadCount; i++){
                   Thread t = new Thread(new MultiThreadedSingletonTestRunnable(clazz, gate));
                   liThread.add(t);
                   t.start();
                }

                // wait for all the threads to get to the gate
                // get current time
                // release the gate to allow threads to continue executing
                // wait for all the threads to complete
                gate.await();
                long time = System.currentTimeMillis();
                for(Thread t: liThread){
                    t.join();
                }

                // get the time delta
                // write the result to the map
                time = (-time + System.currentTimeMillis());
                System.out.println("class: "
                        + clazz.getName()
                        + ", duration: "
                        + time
                        + " ms");

                map.put(clazz, time);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

        // LazyLoadedSingleton with synchronized method should be slower then the other two
        assertTrue(map.get(EagerThreadSafeSingleton.class) < map.get(LazyThreadSafeSynchronizedSingleton.class));
        assertTrue(map.get(LazyThreadSafeSyncBlockSingleton.class) < map.get(LazyThreadSafeSynchronizedSingleton.class));
    }

    private class MultiThreadedSingletonTestRunnable implements Runnable {

        private Class singletonClazz;
        private CyclicBarrier gate;

        private MultiThreadedSingletonTestRunnable(Class singletonClazz, CyclicBarrier gate) {
            this.singletonClazz = singletonClazz;
            this.gate = gate;
        }

        @Override
        @SuppressWarnings("unchecked")
        public void run() {
            try{
                gate.await();
                Method method = singletonClazz.getDeclaredMethod("getInstance");
                method.setAccessible(true);
                for(int i = 0; i < 100000; i++){
                    method.invoke(null);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

}
