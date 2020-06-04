package restful;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * In Spring’s approach to building RESTful web services, HTTP requests are handled by a controller.
 * These components are identified by the @RestController annotation, and the GreetingController shown in the following listing
 * (from src/main/java/com/example/restservice/GreetingController.java)
 * handles GET requests for /greeting by returning a new instance of the Greeting class:
 * @author shivanidwivedi on 03/06/20
 * @project JavaProgramming
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        log.info("greeting : "+counter.get());
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
