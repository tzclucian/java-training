package basics.apps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tzc.geometry.shape.Drawable;
import org.tzc.geometry.shape.LineSegment;

public class BeanDefinitionInheritance {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-definition-inheritance-app.xml");

        Drawable parentLine = (LineSegment) applicationContext.getBean("parentLine");
        parentLine.draw();

        Drawable line = (LineSegment) applicationContext.getBean("line");
        line.draw();

    }
}
