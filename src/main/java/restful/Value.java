package restful;

/**
 * @author shivanidwivedi on 03/06/20
 * @project JavaProgramming
 *  An additional class, to embed the inner quotation itself. The Value class fills that need.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Value {

    private Long id;
    private String quote;

    public Value() {
    }

    @Override
    public String toString() {
        return "Value{" +
                "id=" + id +
                ", quote='" + quote + '\'' +
                '}';
    }
}
