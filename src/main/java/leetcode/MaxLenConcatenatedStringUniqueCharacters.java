package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author shivanidwivedi on 16/09/20
 * @project JavaProgramming
 */
public class MaxLenConcatenatedStringUniqueCharacters {
    static int length = 0;
    public static int maxLength(List<String> arr) {
        maxUnique(arr, 0, "");
        return length;
    }

    private static void maxUnique(List<String> arr, int index, String current){
        if(isUnique(current)){
            length = Math.max(length, current.length());
        }else{
            return;
        }

        for(int i = index; i < arr.size(); i++){
            if(isUnique(arr.get(i))){
                maxUnique(arr, index+1, current+arr.get(i));
            }
        }
    }

    private static boolean isUnique(String str){
        HashSet<Character> set = new HashSet<>();
        for(char ch : str.toCharArray()){
            if(set.contains(ch)){
                return false;
            }else set.add(ch);
        }
        return true;
    }
}
