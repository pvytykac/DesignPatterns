package org.pvytykac.creational.singleton;

/**
 * Lazy loaded, non thread safe singleton
 */
public class LazyNonThreadSafeSingleton {

    private static LazyNonThreadSafeSingleton INSTANCE;

    private LazyNonThreadSafeSingleton(){
    }

    public static LazyNonThreadSafeSingleton getInstance(){
        if(INSTANCE == null){
            INSTANCE = new LazyNonThreadSafeSingleton();
        }

        return INSTANCE;
    }

}
