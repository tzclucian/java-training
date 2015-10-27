package org.tzc.geometry.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.tzc.geometry.layer.CompositeLayer;
import org.tzc.geometry.shape.Shape;

/**
 * @author Lucian Tuca
 *         26/10/15
 *         java-training
 *
 *         Subject class
 */
public class ProcessableLayer extends CompositeLayer implements Processable {

    private List<LayerProcessor> layerProcessors = new ArrayList<LayerProcessor>();

    private Map<String, Double> results = new HashMap<String, Double>();

    public ProcessableLayer(CompositeLayer layer) {
        for (Shape shape: layer.listAllShapes()) {
            this.add(shape);
        }
    }

    public void registerProcessor(LayerProcessor newLayerProcessor) {
        layerProcessors.add(newLayerProcessor);
    }

    public void unregisterProcessor(LayerProcessor toBeDeletedLayerProcessor) {
        layerProcessors.remove(toBeDeletedLayerProcessor);
    }

    public void notifyProcessor(LayerProcessor layerProcessor) {
        layerProcessor.process(this.listAllShapes());
    }

    public void notifyProcessors() {
        for (LayerProcessor layerProcessor : layerProcessors) {
            double processingResult = layerProcessor.process(this.listAllShapes());
            results.put(layerProcessor.getClass().getSimpleName(), processingResult);
        }
    }

    public Map getProcessingResults() {
        return results;
    }

    public List<LayerProcessor> getLayerProcessors() {
        return layerProcessors;
    }
}
