package restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shivanidwivedi on 03/06/20
 * @project JavaProgramming
 */
@SpringBootApplication
public class RestServiceApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(RestServiceApplication.class, args);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
