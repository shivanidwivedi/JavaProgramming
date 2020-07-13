package hackerrank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author shivanidwivedi on 13/07/20
 * @project JavaProgramming
 *
 * Check whether the given input string is valid or not.
 * The string is valid if all the characters have same frequency and we can also remove only one character from the string.
 */
public class SherlockValidString {
    public static String isValid(String s) {
        HashMap<Character,Integer> frequencies = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!frequencies.containsKey(s.charAt(i))){
                frequencies.put(s.charAt(i),1);
            }else{
                frequencies.put(s.charAt(i),frequencies.get(s.charAt(i))+1);
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int freq : frequencies.values())
        {
            set.add(freq);
        }
        if(set.size() > 2)//More than 2 frequencies
            return "NO";
        else if(set.size() == 1)
            return "YES";
        else{
            int f1 = 0;
            int f2 = 0;
            int f1Count = 0;
            int f2Count = 0;
            int i = 0;
            for(int n : set)
            {
                if(i == 0) f1 = n;
                else f2 = n;
                i++;
            }
            for(int freq : frequencies.values())
            {
                if(freq == f1) f1Count++;
                if(freq == f2) f2Count++;
            }
            if((f1 == 1 && f1Count == 1 ) || (f2 == 1 && f2Count == 1 ))
                return "YES";
            else if ((Math.abs(f1 - f2)  == 1) && (f1Count == 1 || f2Count == 1))
                return "YES";
            else
                return "NO";
        }
    }
}
