package leetcode;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shivanidwivedi on 02/03/21
 * @project JavaProgramming
 */
public class WordLadderBidirectionalBFS {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return 0;
        }

        Set<String> start = new HashSet<>();
        start.add(beginWord);

        Set<String> end = new HashSet<>();
        end.add(endWord);

        int level = 0;
        while(!start.isEmpty() && !end.isEmpty()){
            int size = start.size();
            Set<String> temp = new HashSet<>();
            for(String current : start){
                for(int i = 0; i < current.length(); i++){
                    char[] word = current.toCharArray();
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        word[i] = ch;
                        String checkWord = String.valueOf(word);
                        if(end.contains(checkWord)){
                            return level + 2;
                        }
                        if(!checkWord.equals(current) && set.contains(checkWord)){
                            temp.add(checkWord);
                            set.remove(checkWord);
                        }
                    }
                }
            }
            level++;
            start = end;
            end = temp;
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadderBidirectionalBFS obj = new WordLadderBidirectionalBFS();
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        Assert.assertEquals(5, obj.ladderLength("hit", "cog",list));
    }
}
