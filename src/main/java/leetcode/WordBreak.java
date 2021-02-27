package leetcode;

import org.junit.Assert;

import java.util.*;

/**
 * @author shivanidwivedi on 27/02/21
 * @project JavaProgramming
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] visited = new boolean[s.length()];
        while(!queue.isEmpty()){
            int start = queue.remove();
            if(!visited[start]){
                for(int end = start + 1; end <= s.length(); end++){
                    if(wordDictSet.contains(s.substring(start, end))){
                        queue.add(end);
                        if(end == s.length()){
                            return true;
                        }
                    }
                }
                visited[start] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        Assert.assertEquals(true, wordBreak.wordBreak("leetcode", list));
    }
}
