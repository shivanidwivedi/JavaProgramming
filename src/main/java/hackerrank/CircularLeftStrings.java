package hackerrank;

/**
 * @author shivanidwivedi on 20/09/20
 * @project JavaProgramming
 */
public class CircularLeftStrings {
    public static int countStrings(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] array = s.toCharArray();
        int count = 0;
        int i = 0;
        String currenString = s;
        while(i < s.length()){
            String str = getNewString(currenString);
            currenString = str;
            if(str.charAt(0) == str.charAt(str.length()-1)){
                count++;
            }
            i++;
        }
        return count;
    }

    private static String getNewString(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < s.length(); i++){
            sb.append(s.charAt(i));
        }
        sb.append(s.charAt(0));
        return sb.toString();
    }

    public static void main(String[] s){
        System.out.println(countStrings("bbbbb"));
    }
}
