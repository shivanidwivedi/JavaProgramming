package leetcode.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 07/06/20
 * @project JavaProgramming
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * Time Complexity: O(n), where n==len(s). Each index is visited once.
 * Space Complexity: O(n). For the cpp implementation, O(1) if return string is not considered extra space.
 */
public class ZigZagConversion {

    public String convertRows(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < Math.min(numRows, s.length()); i++){
            rows.add(new StringBuilder());
        }

        int currentRow = 0;
        boolean goingDown = false;

        for(char ch : s.toCharArray()){
            rows.get(currentRow).append(ch);
            if(currentRow == 0 || currentRow == numRows - 1){
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder row : rows){
            result.append(row);
        }
        return result.toString();
    }


    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int cycleLen = 2*numRows-2;

        for(int i = 0; i < numRows; i++){
            for(int j = 0; j+i < n; j+= cycleLen){
                sb.append(s.charAt(j+i));
                if(i != 0 && i != numRows - 1 && j + cycleLen-i < n){
                    sb.append(s.charAt(j + cycleLen-i));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        System.out.println(zigZagConversion.convert("PAYPALISHIRING", 3));
        System.out.println(zigZagConversion.convert("PAYPALISHIRING", 4));
        System.out.println(zigZagConversion.convertRows("PAYPALISHIRING", 3));
        System.out.println(zigZagConversion.convertRows("PAYPALISHIRING", 4));
    }
}
