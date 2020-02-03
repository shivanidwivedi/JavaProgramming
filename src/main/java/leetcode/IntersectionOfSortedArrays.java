package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IntersectionOfSortedArrays {
    public static List<Integer> getIntersection(int[] arr1, int[] arr2, int[] arr3){
        HashSet<Integer> set1 = new HashSet<>(arr1.length);
        for(int i = 0; i< arr1.length; i++){
            set1.add(arr1[i]);
        }
        HashSet<Integer> set12 = new HashSet<>(arr2.length);
        for(int i = 0; i< arr2.length; i++){
            if(set1.contains(arr2[i])) {
                set12.add(arr2[i]);
            }
        }
        List<Integer> list = new ArrayList<>(arr3.length);
        for(int i = 0; i< arr3.length; i++){
            if(set12.contains(arr3[i]))
                list.add(arr3[i]);
        }
        return list;
    }

}
