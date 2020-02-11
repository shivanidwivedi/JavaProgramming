package leetcode.Strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 11/02/20
 * @project JavaProgramming
 */
public class DefangingIPTest {

    @Test
    public void defangIPaddr_test(){
        Assert.assertEquals("1[.]1[.]1[.]1",DefangingIP.defangIPaddr("1.1.1.1"));
        Assert.assertEquals("255[.]100[.]50[.]0",DefangingIP.defangIPaddr("255.100.50.0"));
    }

    @Test
    public void defangIPaddr2_test(){
        Assert.assertEquals("1[.]1[.]1[.]1",DefangingIP.defangIPaddr_2("1.1.1.1"));
        Assert.assertEquals("255[.]100[.]50[.]0",DefangingIP.defangIPaddr_2("255.100.50.0"));
    }

    @Test
    public void defangIPaddr3_test(){
        Assert.assertEquals("1[.]1[.]1[.]1",DefangingIP.defangIPaddr_3("1.1.1.1"));
        Assert.assertEquals("255[.]100[.]50[.]0",DefangingIP.defangIPaddr_3("255.100.50.0"));
    }
}
