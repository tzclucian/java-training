import java.util.Map;

import org.junit.Test;
import org.tzc.geometry.builders.LayerBuilder;
import org.tzc.geometry.observer.ProcessableLayer;
import org.tzc.geometry.observer.TotalAreaCalculator;
import org.tzc.geometry.shape.Point;
import org.tzc.geometry.shape.polygonal.quadrilateral.Parallelogram;
import org.tzc.geometry.shape.polygonal.quadrilateral.Quadrilateral;
import org.tzc.geometry.shape.polygonal.quadrilateral.Rectangle;
import org.tzc.geometry.shape.polygonal.quadrilateral.Square;
import org.tzc.geometry.shape.polygonal.triangle.IsoscelesTriangle;
import org.tzc.geometry.shape.polygonal.triangle.RightTriangle;
import org.tzc.geometry.shape.polygonal.triangle.Triangle;

import static org.junit.Assert.assertEquals;

public class ObserverTest {

    @Test
    public void totalAreaCalculatorTest() {
        Point a = new Point(0, 0);
        Point b = new Point(20, 0);
        Point c = new Point(20, 20);
        Point d = new Point(0, 20);

        Quadrilateral quadrilateral = new Quadrilateral(a, b, c, d);
        Parallelogram parallelogram = new Parallelogram(a, b, c, d);
        Rectangle rectangle = new Rectangle(a, b, c, d);
        Square square = new Square(a, b, c, d);
        Triangle rightTriangle = new RightTriangle(a, b, c);
        Triangle isoscelesTriangle = new IsoscelesTriangle(a, b, c);

        LayerBuilder layerBuilder = new LayerBuilder();
        layerBuilder.
                addShape(quadrilateral).
                addShape(parallelogram).
                addShape(rectangle).
                addShape(square).
                addShape(rightTriangle).
                addShape(isoscelesTriangle);
        ProcessableLayer processableLayer = new ProcessableLayer(layerBuilder.build());

        TotalAreaCalculator totalAreaCalculator = new TotalAreaCalculator();
        processableLayer.registerProcessor(totalAreaCalculator);

        processableLayer.notifyProcessors();
        Map results = processableLayer.getProcessingResults();

        double totalArea = (Double) results.get(TotalAreaCalculator.class.getSimpleName());
        assertEquals(2000.0, totalArea, 0.01);
    }
}
