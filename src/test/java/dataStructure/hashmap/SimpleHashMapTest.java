package dataStructure.hashmap;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gaganmani
 * @date 05/10/19
 * @package dataStructure.hashmap
 */
public class SimpleHashMapTest {

    @Test
    public void testAddValues(){
        SimpleHashMap simpleHashMap = new SimpleHashMap();

        String shivaniKey = "shivani";
        String gaganKey = "gagan";

        Assert.assertNull(simpleHashMap.demoHashMap);
        //add some values
        simpleHashMap.addValues(gaganKey,1);
        simpleHashMap.addValues(shivaniKey,0);
        //Test
        Assert.assertNotNull("hashmap not null",simpleHashMap.demoHashMap);
        Assert.assertEquals(2, simpleHashMap.demoHashMap.size());

        int shivaniValue = simpleHashMap.demoHashMap.get(shivaniKey);
        int gaganValue = simpleHashMap.demoHashMap.get(gaganKey);
        Assert.assertNotNull("shivani should not be null",shivaniValue);
        Assert.assertNotNull("gagan should not be null",gaganValue);
        Assert.assertEquals(1, gaganValue);
        Assert.assertEquals(0, shivaniValue);

        //override shivani
        simpleHashMap.addValues(shivaniKey,2);
        Assert.assertNotEquals(1, (int)simpleHashMap.demoHashMap.get(shivaniKey));
        Assert.assertEquals(2, (int)simpleHashMap.demoHashMap.get(shivaniKey));

        System.out.println("Shivani hashcode() is: "+shivaniKey.hashCode());
        System.out.println("Gagan hashcode() is: "+gaganKey.hashCode());


    }
}
