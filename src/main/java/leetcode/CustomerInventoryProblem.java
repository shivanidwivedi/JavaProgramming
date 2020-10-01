package leetcode;

import java.util.*;

/**
 * @author shivanidwivedi on 30/09/20
 * @project JavaProgramming
 */
public class CustomerInventoryProblem {
    public static boolean canFulfil(int[][] inventory, int[][] orders){
        TreeMap<Integer, Integer> mapInventory = new TreeMap<>(Collections.reverseOrder());
        for (int[] arr : inventory){
            mapInventory.put(arr[0], arr[1]);
        }
        System.out.println(mapInventory);
        Arrays.sort(orders, (a,b) -> b[0]-a[0]);
        for(int[] order : orders){
            if (mapInventory.containsKey(order[0]) && mapInventory.get(order[0]) > order[1]){
                mapInventory.put(order[0], mapInventory.get(order[0])-order[1]);
                if(mapInventory.get(order[0]) == 0){
                    mapInventory.remove(order[0]);
                }
            }//else if()
        }
        return true;
    }

    public static void main(String[] s){
        System.out.println(canFulfil(new int[][]{{1,5},{5,6},{3,8}}, new int[][]{{1,2},{2,5},{3,5}}));
    }
}
