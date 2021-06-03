package random;

import java.util.*;

/**
 * @author shivanidwivedi on 03/06/21
 * @project JavaProgramming
 */
public class APractice8 {
    public List<Integer> getIndexes(int[] input, int flightDuration){
        List<Integer> list = new ArrayList<>();
        int[] ans = new int[2];
        int target = flightDuration - 30;
        if (target <= 0) return list;

        // use a dynamic array list
        List<CurrentPair> sorted = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            sorted.add(new CurrentPair(i, input[i]));
        }
        Collections.sort(sorted, (i, j) -> (i.val - j.val));

        int closestSum = 0;

        // two pointers
        int left = 0, right = input.length - 1;
        while (left < right) {
            CurrentPair leftPair = sorted.get(left);
            CurrentPair rightPair = sorted.get(right);
            int sum = leftPair.val + rightPair.val;
            if (sum > target) {
                right--;
            } else {
                // found duplicates
                if (sum == closestSum) {
                    int currentLongestMovie = input[ans[1]];
                    if (rightPair.val > currentLongestMovie) {
                        // found longer movie
                        ans[0] = leftPair.index;
                        ans[1] = rightPair.index;
                    }
                } else if (sum > closestSum) {
                    closestSum = sum;
                    ans[0] = leftPair.index;
                    ans[1] = rightPair.index;
                }
                left++;
            }
        }

        list.add(ans[0]);
        list.add(ans[1]);
        return list;
    }

    public static void main(String[] args) {
        APractice8 obj = new APractice8();
        System.out.println(obj.getIndexes(new int[]{90,85,75,60,120,150,125}, 250));
    }
}

class CurrentPair{
    int index;
    int val;
    CurrentPair(int index, int val){
        this.index = index;
        this.val = val;
    }
}
