package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 10/08/20
 * @project JavaProgramming
 *
 * A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part,
 * and return a list of integers representing the size of these parts.
 *
 * Example 1:
 *
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 *
 * TC: O(N)
 */
public class PartitionLabels {
    public static List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        if(S == null || S.length() == 0){
            return result;
        }
        int[] endIndex = new int[26];
        for(int i = 0; i < S.length(); i++){
            endIndex[S.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = endIndex[S.charAt(0) - 'a'];

        for(int i = 1; i < S.length(); i++){
            int starti = i;
            int endi = endIndex[S.charAt(i) - 'a'];
            if(end >= starti){
                end = Math.max(end, endi);
            }else{
                result.add(end - start + 1);
                start = starti;
                end = endi;
            }
        }
        result.add(end - start + 1);
        return result;
    }
    public static void main(String[] s){
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels("aaaaaaa"));
    }
}
