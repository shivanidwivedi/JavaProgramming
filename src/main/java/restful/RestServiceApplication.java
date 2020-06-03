package restful;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author shivanidwivedi on 03/06/20
 * @project JavaProgramming
 * add a few other things to the RestServiceApplication class to get it to show quotations from our RESTful source. You need to add:
 * A logger, to send output to the log (the console, in this example).
 * A RestTemplate, which uses the Jackson JSON processing library to process the incoming data.
 * A CommandLineRunner that runs the RestTemplate (and, consequently, fetches our quotation) on startup.
 */
@SpringBootApplication
public class RestServiceApplication {
    private static final Logger log = LoggerFactory.getLogger(RestServiceApplication.class);

    public static void main(String[] args) {
        try {
            SpringApplication.run(RestServiceApplication.class, args);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Greeting greet = restTemplate.getForObject(
                    "http://localhost:8080/greeting", Greeting.class);
            Quote quote = restTemplate.getForObject(
                    "https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            log.info(greet.toString());
            log.info(quote.toString());
        };
    }

}
