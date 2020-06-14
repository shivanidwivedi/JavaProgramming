package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author shivanidwivedi on 13/06/20
 * @project JavaProgramming
 */
public class UniqueIntegers {
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {

        if(arr.length <= k || arr == null || arr.length == 0){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr){
                map.put(i, map.getOrDefault(i,0) + 1);
        }
        System.out.println(map);

        Map<Integer, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sortedMap);
        Iterator<Map.Entry<Integer, Integer>> iterator = sortedMap.entrySet().iterator();
        while(k != 0 && iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry =  iterator.next();
            int value = entry.getValue();
            if (k >= value) {
                k = k - value;
                sortedMap.put(entry.getKey(), 0);
            }
        }
       int result = sortedMap.entrySet().stream()
                .filter(x -> x.getValue() > 0).mapToInt(x -> 1).sum();

        return result;
    }
    public static void main(String s[]){

        UniqueIntegers uniqueIntegers = new UniqueIntegers();
        uniqueIntegers.findLeastNumOfUniqueInts(new int[]{4,3,1,1,4},3);
    }
}
