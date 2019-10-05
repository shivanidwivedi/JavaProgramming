package dataStructure.hashmap;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gaganmani
 * @date 05/10/19
 * @package dataStructure.hashmap
 */
public class CustomHashMapTest {

    @Test
    public void testCustomHaspMap(){
        CustomHashMap customHashMap = new CustomHashMap();

        CustomHashMap.EmployeeKey gagan = customHashMap.new EmployeeKey("gagan", 30);
        CustomHashMap.EmployeeKey shivani = customHashMap.new EmployeeKey("shivani", 28);
        CustomHashMap.EmployeeKey futureGagan = customHashMap.new EmployeeKey("gagan", 30);

        customHashMap.employeeMap.put(gagan, 1);
        customHashMap.employeeMap.put(shivani, 2);
        customHashMap.employeeMap.put(futureGagan, 3);

        //Assert.assertNotEquals(2, customHashMap.employeeMap.size());
        //Assert.assertEquals("why the fuck did it duplicate futureGagan man ? ",3, customHashMap.employeeMap.size());
        Assert.assertEquals(2, customHashMap.employeeMap.size());
        customHashMap.employeeMap.put(gagan, 10);
        customHashMap.employeeMap.put(gagan, 11);
        customHashMap.employeeMap.put(gagan, 10000);
        Assert.assertEquals(2, customHashMap.employeeMap.size());
    }
}
