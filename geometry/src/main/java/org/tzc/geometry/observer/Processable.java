package org.tzc.geometry.observer;

import java.util.Map;

/**
 * @author Lucian Tuca
 *         26/1015
 *         java-training
 *
 *         Subject interface
 */
public interface Processable {
    void registerProcessor(LayerProcessor layerProcessor);
    void unregisterProcessor(LayerProcessor layerProcessor);
    void notifyProcessor(LayerProcessor layerProcessor);
    void notifyProcessors();
    Map getProcessingResults();
}
