import org.junit.Test;
import org.tzc.geometry.builders.triangle.EquilateralTriangleBuilder;
import org.tzc.geometry.shape.polygonal.triangle.EquilateralTriangle;

import static org.junit.Assert.assertEquals;

public class BuildersTest {

    @Test
    public void layerBuilderTest() {
        EquilateralTriangle equilateralTriangle= new EquilateralTriangleBuilder().bySideLength(7).build();
        assertEquals(21, equilateralTriangle.calculatePerimeter(), 2);
        assertEquals(21.22, equilateralTriangle.calculateArea(), 2);
    }
}
