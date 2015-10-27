import org.junit.Test;
import org.tzc.geometry.factory.ExampleShapeFactory;
import org.tzc.geometry.layer.SingletonLayer;
import org.tzc.geometry.shape.Shape;
import org.tzc.geometry.shape.ShapeType;

import static org.junit.Assert.assertEquals;

public class SingletonLayerTest {
    private SingletonLayer firstThreadInstance;
    private SingletonLayer secondThreadInstance;

    @Test
    public void simpleSingletonTest() {

        Shape square = ExampleShapeFactory.createExampleShape(ShapeType.SQUARE);
        Shape circle = ExampleShapeFactory.createExampleShape(ShapeType.CIRCLE);

        SingletonLayer firstInstance = SingletonLayer.getInstance();
        firstInstance.add(square);
        firstInstance.add(circle);

        SingletonLayer secondInstance = SingletonLayer.getInstance();

        assertEquals(firstInstance.listAllShapes().size(), secondInstance.listAllShapes().size());
    }

    @Test
    public void singletonLayerThreadsTest() {
        Runnable firstThread = new FirstThread();
        Runnable secondThread = new SecondThread();

        new Thread(firstThread).start();
        new Thread(secondThread).start();
    }

    private class FirstThread implements Runnable {
        public void run() {
            firstThreadInstance = SingletonLayer.getInstance();
            firstThreadInstance.add(ExampleShapeFactory.createExampleShape(ShapeType.SQUARE));
            assertEquals(1, firstThreadInstance.size());
        }
    }

    private class SecondThread implements Runnable {
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            secondThreadInstance = SingletonLayer.getInstance();
            secondThreadInstance.add(ExampleShapeFactory.createExampleShape(ShapeType.CIRCLE));
            assertEquals(2, secondThreadInstance.size());
        }
    }

}
