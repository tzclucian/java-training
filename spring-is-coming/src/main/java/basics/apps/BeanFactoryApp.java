package basics.apps;

import java.io.File;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.tzc.geometry.shape.Point;

/**
 *
 */
public class BeanFactoryApp {


    public static void main(String[] args) {
        ClassLoader classLoader = BeanFactoryApp.class.getClassLoader();
        File file = new File(classLoader.getResource("bean-factory-app.xml").getFile());

        BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource(file.getPath()));
        Point point = (Point) beanFactory.getBean("point");
        System.out.println(point.toString());
    }


}
