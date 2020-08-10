package leetcode;

import java.util.HashMap;

/**
 * @author shivanidwivedi on 09/08/20
 * @project JavaProgramming
 */
public class RomanToInteger {
    public static int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("M",1000);
        map.put("D",500);
        map.put("C",100);
        map.put("L",50);
        map.put("X",10);
        map.put("V",5);
        map.put("I",1);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        int sum = 0;
        int i = 0;
        while (i < s.length()){
            if (i < s.length() - 1){
                String current = s.substring(i, i + 2);
                if (map.containsKey(current)) {
                    sum += map.get(current);
                    i += 2;
                    continue;
                }
            }
            String single = s.substring(i, i+1);
            sum += map.get(single);
            i++;
        }
        return sum;
    }

    public static void main(String[] s){
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
