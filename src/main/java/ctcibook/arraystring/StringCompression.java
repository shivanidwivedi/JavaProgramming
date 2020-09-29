package ctcibook.arraystring;

/**
 * @author shivanidwivedi on 29/09/20
 * @project JavaProgramming
 * Implement a method to perform basic string compression using the counts of
 * repeated characters. For example, the string aabcccccaaa would become
 * a2blc5a3. If the "compressed" string would not become smaller than the original
 * string, your method should return the original string.
 */

//The runtime is 0(p + k2), where p is the size of the original string and k is the number
//of character sequences. For example, if the string is aabccdeeaa, then there are six
//character sequences. It's slow because string concatenation operates in 0(n2) time
public class StringCompression {
    public static String compressBad(String str){
        String result = "";
        char last = str.charAt(0);
        int count = 1;
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == last){
                count++;
            }else {
                result += last+""+count;
                last = str.charAt(i);
                count = 1;
            }
        }
        return result+last+count;
    }

    public static void main(String[] s){
        System.out.println(compressBad("aabbbccccd"));
        System.out.println(compressBad("ab"));
        System.out.println(compressBetter("aabbbccccd"));
        System.out.println(compressBetter("ab"));
        System.out.println(compressBetter("aaaaaaaaaaaaaaaaaaab"));
    }
//Make use of StringBuffer
    public static String compressBetter(String str){
        //check if compression would be longer in size, then return the input string
        int size = countCompression(str);
        if(size >= str.length()){
            return str;
        }
        StringBuffer result = new StringBuffer();
        char last = str.charAt(0);
        int count = 1;
        for(int i = 1; i < str.length(); i++){
            if (str.charAt(i) == last){
                count++;
            }else {
                result.append(last);
                result.append(count);
                last = str.charAt(i);
                count = 1;
            }
        }
        //characters are inserted when repeated character changes. We need to update the string at
        // the end of the method as well, since the very last set of
        //* repeated characters wouldn't be set in the compressed string
        result.append(last);
        result.append(count);
        return result.toString();
    }
//calculate size of the compression string
    private static int countCompression(String str){
        if (str == null || str.isEmpty()) return 0;
        char last = str.charAt(0);
        int size = 0;
        int count = 1;
        for (int i = 1; i < str.length(); i++)
        if (str.charAt(i) == last) {
            count++;
        }else {
            last = str.charAt(i);
            size += 1+String.valueOf(count).length();
            count = 1;
        }
        size += 1+String.valueOf(count).length();
        return size;
    }
}
