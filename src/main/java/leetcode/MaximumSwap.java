package leetcode;

import org.junit.Assert;

/**
 * @author shivanidwivedi on 28/02/21
 * @project JavaProgramming
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] array = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for(int i = 0; i < array.length; i++){
            last[array[i] - '0'] = i;
        }
        for(int i = 0; i < array.length; i++){
            for(int d = 9; d > array[i] - '0'; d--){
                if(last[d] > i){
                    char temp = array[i];
                    array[i] = array[last[d]];
                    array[last[d]] = temp;
                    return Integer.valueOf(new String(array));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        MaximumSwap obj = new MaximumSwap();
        Assert.assertEquals(7236, obj.maximumSwap(2736));
    }
}
