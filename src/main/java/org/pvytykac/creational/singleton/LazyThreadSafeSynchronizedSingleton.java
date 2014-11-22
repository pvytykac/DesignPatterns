package org.pvytykac.creational.singleton;

/**
 * Lazy loaded, thread safe singleton (synchronized getInstance method)
 */
public class LazyThreadSafeSynchronizedSingleton {

    private static LazyThreadSafeSynchronizedSingleton INSTANCE;

    private LazyThreadSafeSynchronizedSingleton() {
    }

    public static synchronized LazyThreadSafeSynchronizedSingleton getInstance(){
        if(INSTANCE == null){
            INSTANCE = new LazyThreadSafeSynchronizedSingleton();
        }

        return INSTANCE;
    }

}
