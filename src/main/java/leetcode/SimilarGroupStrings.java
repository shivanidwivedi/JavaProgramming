package leetcode;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shivanidwivedi on 03/03/21
 * @project JavaProgramming
 */
public class SimilarGroupStrings {
    public int numSimilarGroups(String[] strs) {
        int[] parent = new int[strs.length];
        //each element represent its parent
        // initially each index is parent of itself, index represents corresponding word

        for(int i = 0; i < strs.length; i++){
            parent[i] = i;
        }

        // loop for each word
        for(int i = 0; i < strs.length; i++){
            for(int j = i+1; j < strs.length; j++){
                if(isValid(strs[i], strs[j])){ // if its valid merge both the words into single group
                    union(i, j, parent);
                }
            }
        }

        Set<Integer> set = new HashSet<>(); // iterate through parent array
        for(int i = 0; i < parent.length; i++){
            set.add(find(i, parent));
        }
        return set.size();
    }

    private void union(int s1, int s2, int[] parent){
        int parent1 = find(s1, parent);
        int parent2 = find(s2, parent);
        parent[parent1] = parent2; // make parent for both words similar
    }

    private int find(int x, int[] parent){
        if(parent[x] != x){
            parent[x] = find(parent[x], parent);
        }
        return parent[x]; // find parent for each word/index
    }

    private boolean isValid(String s1, String s2){
        if(s1.equals(s2)){
            return true;
        }
        int swap = 0;
        int index = -1, curr = -1; // stores the mismatch indexes
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                swap++;
                if(swap > 2){ // check if more than 2 mismatch
                    return false;
                }
                index = curr;
                curr = i;
            }

        }
        return swap == 2 && (s1.charAt(index) == s2.charAt(curr))
                && (s1.charAt(curr) == s2.charAt(index));
    }

    public static void main(String[] args) {
        SimilarGroupStrings obj = new SimilarGroupStrings();
        Assert.assertEquals(2, obj.numSimilarGroups(
                new String[]{"tars","rats","arts","star"}));
    }
}
