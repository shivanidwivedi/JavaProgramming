package restful;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;

/**
 * @author shivanidwivedi on 03/06/20
 * Now that you have set up the project and build system, you can create your web service.
 *
 * Begin the process by thinking about service interactions.
 *
 * The service will handle GET requests for /greeting, optionally with a name parameter in the query string.
 * The GET request should return a 200 OK response with JSON in the body that represents a greeting.
 * It should resemble the following output:
 *
 * {
 *     "id": 1,
 *     "content": "Hello, World!"
 * }COPY
 * The id field is a unique identifier for the greeting, and content is the textual representation of the greeting.
 *
 * To model the greeting representation, create a resource representation class.
 * To do so, provide a plain old Java object with fields, constructors,
 * and accessors for the id and content data, as the following listing (from src/main/java/com/example/restservice/Greeting.java) shows:
 * @project JavaProgramming
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

}