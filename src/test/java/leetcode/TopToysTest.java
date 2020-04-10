package leetcode;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 09/04/20
 * @project JavaProgramming
 */
public class TopToysTest {
    @Test
    public void populateNToys() {
        ArrayList<String> topToys = TopToys.populateNToys(2, getToys(), getQuotes());
        Assert.assertEquals(2,topToys.size());
        Assert.assertEquals("first element","gagan",topToys.get(0));
        Assert.assertEquals("second element","shivani",topToys.get(1));


        topToys = TopToys.populateNToys(200, getToys(), getQuotes());
        Assert.assertEquals(3,topToys.size());
        Assert.assertEquals("first element","gagan",topToys.get(0));
        Assert.assertEquals("second element","shivani",topToys.get(1));
        Assert.assertEquals("third element","mayank",topToys.get(2));
    }

    @Test
    public void test_topN() {
        Toy t1 = new Toy("gagan", 2);
        Toy t2 = new Toy("gagan1", 1);
        Toy t3 = new Toy("gagan33", 5);

        List<Toy> toys = new ArrayList<>();
        toys.add(t1);
        toys.add(t2);
        toys.add(t3);
        System.out.println(toys.get(0).count);
        Collections.sort(toys, new ToyComparator());
        System.out.println(toys.get(0).count);
        System.out.println(toys.get(1).count);

        List<String> output = TopToys.getTopNToys(2, toys);
        System.out.println(output.get(0));
        System.out.println(output.get(1));


    }

    @Ignore
    @Test
  /*  public void test_populateNToysHashMap() {
        ArrayList<String> topToys = TopToys.populateNToysHashMap(2, getToys(),getQuotes());
        Assert.assertEquals(2, topToys.size());
    }*/

    private List<String> getToys() {
        List<String> toys = new ArrayList<>();
        toys.add("gagan");
        toys.add("shivani");
        toys.add("mayank");
        toys.add("srk");
        return toys;
    }

    private List<String> getQuotes() {
        String[] quotes = new String[] {
                "gagan is good gagan",
                "shivani is good gagan",
                "mayank is good shivani"
        };
        return Arrays.asList(quotes);
    }
}