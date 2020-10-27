package leetcode.Strings;

/**
 * @author shivanidwivedi on 26/10/20
 * @project JavaProgramming
 */
public class IntegerToRoman {
    public String intToRoman(int num) {

        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];
    }

    public static void main(String[] args) {
        IntegerToRoman convert = new IntegerToRoman();
        System.out.println(convert.intToRoman(98));
        System.out.println(convert.intToRoman(1994));
    }
}
