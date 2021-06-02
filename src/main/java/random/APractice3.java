package random;

import java.util.*;

/**
 * @author shivanidwivedi on 01/06/21
 * @project JavaProgramming
 * arr = [16, 32, 64], T = 3, d = 2, answer is 3. 32 // 2 = 16, and 64 // 2 = 32, then 32 // 2 = 16, 3 divisions needed.
 */
public class APractice3 {
    public int minDivisions(int[] input, int T, int d){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < input.length; i++){
            helper(input[i], map, d);
        }
        int min = Integer.MAX_VALUE;
        for(List<Integer> divisions : map.values()){
            if(divisions.size() >= T){
                Collections.sort(divisions);
                int total = 0;
                for(int i = 0; i < T; i++){
                    total += divisions.get(i);
                }
                min = Math.min(min, total);
            }
        }
        return min;
    }

    public void helper(int i, Map<Integer, List<Integer>> map, int d){
        int count = 0;
        while(i > 0){
            List<Integer> temp = map.getOrDefault(i, new ArrayList<>());
            temp.add(count);
            map.put(i, temp);
            i /= d;
            count++;
        }
    }

    public static void main(String[] args) {
        APractice3 obj = new APractice3();
        System.out.println(obj.minDivisions(new int[]{16,32,64}, 3,2));
        System.out.println(obj.minDivisions(new int[]{1,2,3,4,5}, 3,2));
        System.out.println(obj.minDivisions(new int[]{1,2,10000000}, 2,2));
    }
}
