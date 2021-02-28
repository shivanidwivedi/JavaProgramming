package leetcode;

import org.junit.Assert;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author shivanidwivedi on 28/02/21
 * @project JavaProgramming
 */
public class StrobogrammaticNumberII {
    List<String> res;

    public List<String> findStrobogrammatic(int n) {
        res = new LinkedList<>();
        if(n == 0){
            return res;
        }
        if(n == 1){
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }
        helper(n, 0, "");
        return res;
    }

    private void helper(int n, int index, String temp){
        if(index == n){
            res.add(temp);
            return;
        }
        if(index == 0){
            char[] chars = new char[]{'1', '6', '8', '9'};
            for(char ch : chars){
                helper(n, index + 1, temp + ch);
            }
            return;
        }

        if(index < n / 2){
            char[] chars = new char[]{'0', '1', '6', '8', '9'};
            for(char ch : chars){
                helper(n, index + 1, temp + ch);
            }
            return;
        }

        if((n % 2 == 1) && (index == n/2)){
            char[] chars = new char[]{'0', '1', '8'};
            for(char ch : chars){
                helper(n, index + 1, temp + ch);
            }
            return;
        }

        char c = temp.charAt(n - index - 1);
        Map<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('0', '0');
        helper(n, index + 1, temp + map.get(c));
    }

    public static void main(String[] args) {
        StrobogrammaticNumberII obj = new StrobogrammaticNumberII();
        System.out.println(obj.findStrobogrammatic(2));
        System.out.println(obj.findStrobogrammatic(3));
    }
}
