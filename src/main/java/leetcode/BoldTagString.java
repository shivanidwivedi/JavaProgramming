package leetcode;

import org.junit.Assert;

/**
 * @author shivanidwivedi on 01/03/21
 * @project JavaProgramming
 */
public class BoldTagString {
    public String addBoldTag(String s, String[] dict){
        boolean[] bold = new boolean[s.length()];
        for(int start = 0; start < s.length(); start++){
            int maxEnd = start - 1;
            for(String word : dict){
                if(s.startsWith(word, start)){
                    maxEnd = start + word.length()-1;
                }
            }
            for(int i = start; i <= maxEnd; i++){
                bold[i] = true;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int start = 0; start < s.length(); start++){
            if(!bold[start]){
                stringBuilder.append(s.charAt(start));
                continue;
            }
            stringBuilder.append("<b>");
            int end = start;
            while(end < s.length() && bold[end]){
                end++;
            }
            stringBuilder.append(s.substring(start, end));
            stringBuilder.append("</b>");
            start = end-1;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        BoldTagString boldTagString = new BoldTagString();
        Assert.assertEquals("<b>aaabbc</b>c", boldTagString.addBoldTag(
                "aaabbcc", new String[]{"aaa","aab","bc"}
        ));
        Assert.assertEquals("<b>abc</b>xyz<b>123</b>", boldTagString.addBoldTag(
                "abcxyz123", new String[]{"abc","123"}
        ));
    }
}
