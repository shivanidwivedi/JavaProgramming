package leetcode;

import java.util.HashMap;
import java.util.Stack;

//TODO: address remaining test cases from leetcode
public class ValidParenthesis {
    public static boolean isValidParenthesis(String parenthesisStr){
        if(parenthesisStr.isEmpty()) {
            return false;
        }

        HashMap<Character, Character> map = getParenthesisMap();
        Stack<Character> parenthesisStack = new Stack<>();
        for(int i=0; i<parenthesisStr.length(); i++) {
            char store = parenthesisStr.charAt(i);
            if (map.containsKey(store))
                parenthesisStack.push(store);

            else {
                if (parenthesisStack.isEmpty())
                    return false;

                char top = parenthesisStack.pop();
                if (!map.containsKey(top) || map.get(top) != store)
                    return false;
            }

        }

        if(parenthesisStack.isEmpty()) {
            return true;
        }
        return false;

    }

    private static HashMap<Character, Character> getParenthesisMap(){
        HashMap<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        return map;
    }
}
