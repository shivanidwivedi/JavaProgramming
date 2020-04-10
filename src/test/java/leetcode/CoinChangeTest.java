package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 07/04/20
 * @project JavaProgramming
 */
public class CoinChangeTest {

    @Test
    public void coinChangeBySort() {
        Assert.assertEquals(3, CoinChange.coinChangeBySort(new int[]{1,2,5},11));
        Assert.assertEquals(-1, CoinChange.coinChangeBySort(new int[]{2},3));
        Assert.assertEquals(20, CoinChange.coinChangeBySort(new int[]{186,419,83,408},6249));
    }
}