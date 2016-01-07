package basics.apps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tzc.geometry.shape.polygonal.PolygonalPath;

public class CollectionApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("collection-app.xml");

        PolygonalPath polygonalPath = (PolygonalPath) applicationContext.getBean("polygonalPath");
        polygonalPath.draw();
        System.out.println(polygonalPath.calculateLength());
    }
}
