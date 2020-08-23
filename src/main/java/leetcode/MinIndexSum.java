package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author shivanidwivedi on 23/08/20
 * @project JavaProgramming
 *
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
 * You need to help them find out their common interest with the least list index sum.
 * If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.
 *
 * Example 1:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 * Example 2:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * Output: ["Shogun"]
 * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 */
public class MinIndexSum {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++){
            map.put(list1[i], i);
        }
        int minIndex = Integer.MAX_VALUE;
        List<String> common = new ArrayList<>();
        for(int i = 0; i < list2.length; i++){
            if(map.containsKey(list2[i])){
                if(i + map.get(list2[i]) < minIndex){
                    common.clear();
                    minIndex = i + map.get(list2[i]);
                    common.add(list2[i]);
                }else if(i + map.get(list2[i]) == minIndex){
                    common.add(list2[i]);
                }
            }
        }
        return common.toArray(new String[common.size()]);
    }

    public static void main(String[] s){
        System.out.println(Arrays.toString(findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
    }
}
