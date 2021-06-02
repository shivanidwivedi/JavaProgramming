package random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shivanidwivedi on 02/06/21
 * @project JavaProgramming
 */
public class APractice5 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> tempList = new ArrayList<>();
        LinkedList<Integer> finalRes = new LinkedList<>();
        int[] result = new int[nums.length];

        for(int i=nums.length-1; i>=0; i--) {
            // find the position at which the nums[i] can be placed which will be our result value.
            result[i] = insert(tempList, nums[i]);
            // as soon as we find the position where the nums[i] would go we insert same in our final
            // result list and using LinkedList to append values at the head as we go.
            finalRes.addFirst(result[i]);
        }

        return finalRes;
    }

    int insert(List<Integer> tempList, int num) {
        int left = 0;
        int right = tempList.size()-1;

        while(left <= right) {
            // find best index to insert "num" and add to list and return index value
            int mid = left + (right-left) /2;
            int midVal = tempList.get(mid);

            if(num <= midVal) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }

        tempList.add(left, num);
        return left;
    }

    public static void main(String[] args) {
        APractice5 obj = new APractice5();
        System.out.println(obj.countSmaller(new int[]{5,2,6,1}));
    }
}
