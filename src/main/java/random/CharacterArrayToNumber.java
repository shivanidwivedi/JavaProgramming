package random;

import org.junit.Assert;

/**
 * @author shivanidwivedi on 14/03/21
 * @project JavaProgramming
 */
public class CharacterArrayToNumber {
    public int charToNumber(char[] input){
        int n = input.length;
        int number = 0;
        int i = 0;
        //int MOD = (int)Math.pow(10,9) + 7;
        while(i < input.length){
            int currDigit = input[i] - '0';
            number = number * 10 + currDigit;
            if(number > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("array is out of bound");
            }

            i++;
        }
        return number;
    }

    public static void main(String[] args) {
        CharacterArrayToNumber obj = new CharacterArrayToNumber();
        Assert.assertEquals(2020, obj.charToNumber(new char[]{'2','0','2','0'}));
        Assert.assertEquals(12349, obj.charToNumber(new char[]{'1','2','3','4','9'}));
        Assert.assertEquals(322, obj.charToNumber(new char[]{'0','3','2','2'}));
        Assert.assertEquals(0, obj.charToNumber(new char[]{'0','0','0','0'}));
       // Assert.assertEquals(0, obj.charToNumber(new char[]{'9','0','0','0','3','9','0','0','0','3','9','0','0',
         //       '0','3','9','0','0','0','3','9','0','0','0','3','9','0','0','0','3'}));
        System.out.println(obj.charToNumber(new char[]{'9','0','0','0','3','9','0','0','0','3','9','0','0',
                       '0','3','9','0','0','0','3','9','0','0','0','3','9','0','0','0','3'}));
    }
}
