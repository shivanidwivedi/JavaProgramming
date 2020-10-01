package dataStructure.hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * @author shivanidwivedi on 21/09/20
 * @project JavaProgramming
 */
public class TreeMapDemo {
    public static TreeMap<String, Integer> treeMapDemo(int[] nums){
        TreeMap<String, Integer> treeMap = new TreeMap<>();
            treeMap.put("Shivani", 1);
            treeMap.put("Shivani", 3);
            treeMap.put("Gagan", 2);
            treeMap.put("Himanshu", 2);
        return treeMap;
    }
    public static HashMap<String, Integer> hashMapDemo(int[] nums){
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Shivani", 1);
        hashMap.put("Shivani", 3);
        hashMap.put("Gagan", 2);
        hashMap.put("Himanshu", 2);
        return hashMap;
    }
    public static LinkedHashMap<String, Integer> linkedHashMapDemo(int[] nums){
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Shivani", 1);
        linkedHashMap.put("Shivani", 3);
        linkedHashMap.put("Gagan", 2);
        linkedHashMap.put("Himanshu", 2);
        return linkedHashMap;
    }

    public static void main(String[] s){
        System.out.println(treeMapDemo(new int[]{1,2,1,3,4,2,5,3,4}));
        System.out.println(hashMapDemo(new int[]{1,2,1,3,4,2,5,3,4}));
        System.out.println(linkedHashMapDemo(new int[]{1,2,1,3,4,2,5,3,4}));
    }
}
