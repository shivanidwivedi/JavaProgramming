package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 06/10/20
 * @project JavaProgramming
 */
public class RemoveComments {
    public static List<String> removeComments(String[] source) {
        boolean blockComment = false;
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(String line : source){
            for(int i = 0; i < line.length(); i++){
                String current = i < line.length()-1 ? line.substring(i, i+2) : "";
                if(blockComment){
                    if(current.equals("*/")){
                        blockComment = false;
                        i++;
                    }
                }else if(current.equals("/*")){
                    blockComment = true;
                    i++;
                }else if(current.equals("//")){
                    break;
                }else{
                    sb.append(line.charAt(i));
                }
            }
            if(!blockComment && sb.length() != 0){
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return res;
    }

    public static void main(String[] s){
        System.out.println(removeComments(new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ",
                "   comment for ", "   testing */", "a = b + c;", "}"}));
    }
}
