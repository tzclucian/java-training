import org.apache.commons.lang.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;
import org.tzc.geometry.ExampleShapeFactory;
import org.tzc.geometry.shape.Shape;
import org.tzc.geometry.shape.ShapeType;


public class ShapeFactoryTest {

    @Test
    public void exampleShapeFactoryTest() {
        ShapeType[] shapeTypes = ShapeType.values();

        shapeTypes = (ShapeType[]) ArrayUtils.removeElement(shapeTypes, ShapeType.ShapeType);
        shapeTypes = (ShapeType[]) ArrayUtils.removeElement(shapeTypes, ShapeType.Polygonal);
        shapeTypes = (ShapeType[]) ArrayUtils.removeElement(shapeTypes, ShapeType.Quadrilateral);
        shapeTypes = (ShapeType[]) ArrayUtils.removeElement(shapeTypes, ShapeType.Triangle);
        shapeTypes = (ShapeType[]) ArrayUtils.removeElement(shapeTypes, ShapeType.Rounded);
        shapeTypes = (ShapeType[]) ArrayUtils.removeElement(shapeTypes, ShapeType.POLYGONAL_PATH);
        shapeTypes = (ShapeType[]) ArrayUtils.removeElement(shapeTypes, ShapeType.POLYGON);


        for (ShapeType shapeType : shapeTypes) {
            Shape exampleShape = ExampleShapeFactory.createExampleShape(shapeType);
            Assert.assertNotNull(exampleShape);
            Assert.assertNotNull(exampleShape.calculateArea());
            Assert.assertNotNull(exampleShape.calculatePerimeter());
        }
    }
}
