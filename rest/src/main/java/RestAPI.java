import endpoints.LayerResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * @author Lucian Tuca
 *         25/05/15
 *         java-training
 */
public class RestAPI {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(LayerResource.class, args);
    }
}
