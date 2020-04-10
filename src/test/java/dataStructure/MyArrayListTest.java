package dataStructure;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 10/04/20
 * @project JavaProgramming
 */
public class MyArrayListTest {

    @Test
    public void add() {
        //add
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(2);
        arrayList.add(3);
        Assert.assertEquals(2, arrayList.size());

        //remove
        Assert.assertEquals(0,arrayList.remove(2));
        Assert.assertEquals(1, arrayList.size());

        //add
        arrayList.add(2);
        arrayList.add(3);
        Assert.assertEquals(3, arrayList.size());

        //get
        Assert.assertEquals(3, arrayList.get(3));

        //size
        Assert.assertEquals(3, arrayList.size());

        //add
        for(int i = 4; i < 20; i++){
            arrayList.add(i);
        }

        Assert.assertEquals(19, arrayList.size());
        Assert.assertEquals(18,arrayList.remove(19));
        Assert.assertEquals(17,arrayList.remove(18));
        Assert.assertEquals(16,arrayList.remove(17));

        Assert.assertEquals("[2 3 4 5 6 7 8 9 10 11 12 13 14 15 16]",arrayList.toString());


        //add 20 more
        for(int i = 0; i <= 19; i++){
            arrayList.add(i);
        }
        Assert.assertEquals(36, arrayList.size());
    }

    @Test(expected = RuntimeException.class)
    public void add_null() {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(null);
    }

    @Test
    public void add_String() {
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("gagan");
        arrayList.add("shivani");
        Assert.assertEquals("[gagan shivani]", arrayList.toString());
    }


}