package basics.apps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tzc.geometry.shape.Point;

public class ContextApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context-app.xml");

        Point point = (Point) applicationContext.getBean("point");
        System.out.println(point.toString());

        Point anotherPoint = (Point) applicationContext.getBean("anotherPoint");
        System.out.println(anotherPoint.toString());
    }
}
