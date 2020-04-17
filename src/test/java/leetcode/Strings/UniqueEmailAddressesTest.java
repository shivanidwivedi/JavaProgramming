package leetcode.Strings;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 17/04/20
 * @project JavaProgramming
 */
public class UniqueEmailAddressesTest {

    @Test
    public void numUniqueEmails() {
        Assert.assertEquals(2, UniqueEmailAddresses.numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
    }
}