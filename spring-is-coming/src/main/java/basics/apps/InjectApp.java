package basics.apps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tzc.geometry.shape.Drawable;
import org.tzc.geometry.shape.LineSegment;

public class InjectApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("inject-app.xml");

        Drawable line = (LineSegment) applicationContext.getBean("line");
        line.draw();

        line = (LineSegment) applicationContext.getBean("lineSegmentAlias");
        line.draw();

        line = (LineSegment) applicationContext.getBean("lineSegmentName");
        line.draw();
    }

}
