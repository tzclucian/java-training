package org.tzc.geometry.layer;

import org.tzc.geometry.observer.ProcessableLayer;

/**
 * @author Lucian Tuca
 *         27/10/15
 *         java-training
 *         <p/>
 *         Singleton
 */
public class SingletonLayer extends ProcessableLayer {
    private static SingletonLayer instance = null;

    private SingletonLayer() {}

    public static SingletonLayer getInstance() {
        if (instance == null) {

            synchronized (SingletonLayer.class) {
                if (instance == null) {
                    instance = new SingletonLayer();
                }
            }

            instance = new SingletonLayer();
        }
        return instance;
    }
}
