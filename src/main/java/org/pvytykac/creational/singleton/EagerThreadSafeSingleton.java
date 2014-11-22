package org.pvytykac.creational.singleton;

/**
 * Eagerly loaded, thread safe singleton
 */
public class EagerThreadSafeSingleton {

    private static EagerThreadSafeSingleton INSTANCE = new EagerThreadSafeSingleton();

    private EagerThreadSafeSingleton() {
    }

    public static EagerThreadSafeSingleton getInstance(){
        return INSTANCE;
    }

}
