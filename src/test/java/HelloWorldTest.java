import org.junit.Assert;
import org.junit.Test;

public class HelloWorldTest {

    @Test
    public void test_getMessage(){
        Assert.assertEquals("First Program",HelloWorld.getMessage("First Program"));
    }
}
