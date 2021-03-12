package dataStructure.random;

import com.google.common.base.Enums;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author shivanidwivedi on 08/03/21
 * @project JavaProgramming
 */
public class StringVariation {
    public String getCharCount(String input){
        if(input == null || input.length() == 0){
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < input.length();){
            char ch = input.charAt(i);
            if(Character.isDigit(ch)){
                int number = ch - '0';
                while(i+1 < input.length() && input.charAt(i+1) <= '9'
                && input.charAt(i+1) >= '0'){
                    number = number * 10 + input.charAt(i+1);
                    i++;
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        StringVariation obj = new StringVariation();
        Assert.assertEquals("a1b1c1", obj.getCharCount("abc"));
        Assert.assertEquals("a2b2c2", obj.getCharCount("2(abc)"));
        Assert.assertEquals("a1b2c6", obj.getCharCount("a+2(b+3(c))"));
    }
}
