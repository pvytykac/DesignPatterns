package org.pvytykac.creational.singleton;

import org.junit.Test;

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

//    @Test
//    public void multithreadedSingletonTest(){
//        final int threadCount = 100;
//        Map<Class,Long> map = new HashMap<>();
//        Class[] arr = new Class[]{
//                LazyThreadSafeSynchronizedSingleton.class,
//                LazyThreadSafeSyncBlockSingleton.class,
//                EagerThreadSafeSingleton.class,
//        };
//
//        CyclicBarrier gate = new CyclicBarrier(threadCount + 1);
//        List<Thread> liThread = new ArrayList<>();
//        List<MultiThreadedSingletonTestRunnable> liRunnable = new ArrayList<>();
//        long[] ids = new long[threadCount];
//        for(Class clazz: arr){
//            try{
//                liThread.clear();
//                gate.reset();
//
//                // start all the threads
//               for(int i = 0; i < threadCount; i++){
//                   MultiThreadedSingletonTestRunnable r = new MultiThreadedSingletonTestRunnable(clazz, gate);
//                   Thread t = new Thread(r);
//                   liThread.add(t);
//                   liRunnable.add(r);
//                   t.start();
//                   ids[i] = t.getId();
//                }
//
//                // wait for the gate
//                // wait for all the threads to complete
//                gate.await();
//                for(Thread t: liThread){
//                    t.join();
//                }
//
//                long time = 0;
//                for(MultiThreadedSingletonTestRunnable r: liRunnable){
//                    time += r.getCpuTime();
//                }
//
//                // get the cpu time
//                // write the result to the map
//                System.out.println("class: "
//                        + clazz.getName()
//                        + ", duration: "
//                        + time
//                        + " ms");
//
//                map.put(clazz, time);
//            }catch(Exception ex){
//                ex.printStackTrace();
//            }
//        }
//
//        // LazyLoadedSingleton with synchronized method should be slower then the other two
//        assertTrue(map.get(EagerThreadSafeSingleton.class) < map.get(LazyThreadSafeSynchronizedSingleton.class));
//        assertTrue(map.get(LazyThreadSafeSyncBlockSingleton.class) < map.get(LazyThreadSafeSynchronizedSingleton.class));
//    }
//
//    private class MultiThreadedSingletonTestRunnable implements Runnable {
//
//        private Class singletonClazz;
//        private CyclicBarrier gate;
//        private long cpuTime;
//
//        private MultiThreadedSingletonTestRunnable(Class singletonClazz, CyclicBarrier gate) {
//            this.singletonClazz = singletonClazz;
//            this.gate = gate;
//        }
//
//        @Override
//        @SuppressWarnings("unchecked")
//        public void run() {
//            try{
//                gate.await();
//                Method method = singletonClazz.getDeclaredMethod("getInstance");
//                method.setAccessible(true);
//                for(int i = 0; i < 100000; i++){
//                    method.invoke(null);
//                }
//
//                this.cpuTime = countCpuTime();
//            }catch(Exception ex){
//                ex.printStackTrace();
//            }
//        }
//
//        public long getCpuTime(){
//            return cpuTime;
//        }
//
//        public long countCpuTime() {
//            ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
//            return bean.isCurrentThreadCpuTimeSupported( ) ?
//                    (bean.getCurrentThreadCpuTime() - bean.getCurrentThreadUserTime()) : 0L;
//        }
//    }

}
