package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Students are asked to stand in non-decreasing order of heights for an annual photo.
 * Return the minimum number of students that must move in order for all students to be standing in non-decreasing order of height.
 */
public class HeightChecker {
    public static int heightChecker(Integer arr[]){
        if (arr.length == 1 || arr == null){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>(Arrays.asList(arr));
        if(set.size()==1) {
            return 0;
        }
        int compare[] = new int[arr.length];
        for (int i =0; i< arr.length; i++){
            compare[i] = arr[i];
        }
        Arrays.sort(compare);
        int height =0;
        for (int i =0; i< arr.length; i++){
            if (arr[i] != compare[i])
                height ++;
        }
        return height;
    }
}
