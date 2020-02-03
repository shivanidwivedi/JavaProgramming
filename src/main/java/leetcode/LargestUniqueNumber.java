package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class LargestUniqueNumber {

    /**
     * Sorting method
     * @param arr
     * @return
     */
    public static int largestUniqueNumber_BySorting(int[] arr){
        int max = -1;
        Arrays.sort(arr);
        for(int i = arr.length - 1; i >= 0; i--){
            max = arr[i];
            boolean isUniqueElement = true;
            while(i > 0 && arr[i-1] == max) {
                i--;
                isUniqueElement = false;
            }
            if(isUniqueElement) {
                return max;
            }
            if(arr[0] == arr[1] && arr[0] == max) {
                max = -1;
            }
        }
        return max;
    }
    public static int largestUniqueNumber(int []arr){
        HashMap<Integer,Integer> maxMap = arrayToMap(arr);
        int max = -1;
        for(int key : maxMap.keySet()){
            int value = maxMap.get(key);
            if (value == 1 && key > max){
                max = key;
            }
        }
        return max;
    }

    static HashMap<Integer, Integer> arrayToMap(int []arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            if (!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }
            else {
                map.put(arr[i],map.get(arr[i])+1);
            }
        }
        return map;
    }


}
