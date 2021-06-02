package random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shivanidwivedi on 02/06/21
 * @project JavaProgramming
 */
public class APractice4 {
    public static List<Integer> numberOfItems(String s, int[] startIndices, int[] endIndices) {
        int[] mem = new int[s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '|') {
                mem[i] = count;
            } else {
                ++count;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < startIndices.length; ++i) {
            int start = startIndices[i] - 1;
            int end = endIndices[i] - 1;

            while (start < end && s.charAt(start) != '|') ++start;
            while (start < end && s.charAt(end) != '|') --end;

            ans.add(mem[end] - mem[start]);
        }
        return ans;
    }

    public static void main(String[] args) {
        APractice4 obj = new APractice4();
        System.out.println(obj.numberOfItems("|**|*|*", new int[]{1,1}, new int[]{5,6}));
    }
}
