package leetcode.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 25/10/20
 * @project JavaProgramming
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int currentWidth = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            currentWidth = words[i].length();
            if(sb.length() != 0){
                sb.append(" ");
            }
            if(currentWidth + sb.length() < maxWidth){
                sb.append(words[i]);
            }
            else if(currentWidth + sb.length() > maxWidth){
                result.add(sb.toString());
                sb.setLength(0);
                sb.append(words[i]);
            }
        }
        sb.setLength(0);
        sb.append(words[words.length-1]);
        result.add(sb.toString());
        List<String> resultant = appendSpaces(result, maxWidth);

        return resultant;
    }

    private List<String> appendSpaces(List<String> result, int maxWidth){
        List<String> finalRes = new ArrayList<>();
        int remainingSpaces = 0;
        int append = 0;
        for(String str : result){
            str = str.trim();
            int stringLen = str.length();
            String[] splitArray = str.split(" ");
            int numberOfWords = splitArray.length;
            int remainingWidth = maxWidth - stringLen;
            if(numberOfWords > 1){
                append = remainingWidth / (numberOfWords-1);
                remainingSpaces = remainingWidth % (numberOfWords-1);
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < splitArray.length; i++){
                sb.append(splitArray[i]);
                for(int j = 0; j <= append; j++){
                    sb.append(" ");
                }
                if(remainingSpaces > 0){
                    sb.append(" ");
                    remainingSpaces--;
                }
            }
            finalRes.add(sb.toString());
        }
        return finalRes;
    }

    public static void main(String[] args) {
        TextJustification textJustification = new TextJustification();
        System.out.println(textJustification.fullJustify(new String[]
                {"This", "is", "an", "example", "of", "text", "justification."}, 16));
    }
}
