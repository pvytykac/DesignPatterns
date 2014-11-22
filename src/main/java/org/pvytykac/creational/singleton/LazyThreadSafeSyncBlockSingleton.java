package org.pvytykac.creational.singleton;

/**
 * Lazy loaded, thread safe singleton (synchronized block in getInstance method)
 */
public class LazyThreadSafeSyncBlockSingleton {

    private static volatile LazyThreadSafeSyncBlockSingleton INSTANCE;

    private LazyThreadSafeSyncBlockSingleton() {
    }

    public static LazyThreadSafeSyncBlockSingleton getInstance(){
        if(INSTANCE == null){
            synchronized (LazyThreadSafeSyncBlockSingleton.class){
                if(INSTANCE == null){
                    INSTANCE = new LazyThreadSafeSyncBlockSingleton();
                }
            }
        }

        return INSTANCE;
    }

}
