package leetcode;

import java.util.HashMap;

public class AnagramMapping_HM {
    public static int[] anagramMappings(int[] arr1, int[] arr2){
        if(arr1==null && arr2==null) {
            return null;
        }
        if(arr1.length!=arr2.length) {
            return null;
        }

        return getIndex(createHashMap(arr2), arr1);
    }

    private static HashMap<Integer,Integer> createHashMap(int [] arr2){
        HashMap<Integer,Integer> map = new HashMap();
        for(int i= 0; i<arr2.length; i++){
            map.put(arr2[i],i);
        }
        return map;
    }

    private static int[] getIndex(HashMap<Integer,Integer> map, int arr[]){
        int[] indices = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            indices[i] = map.get(arr[i]);
        }
        return indices;
    }
}
