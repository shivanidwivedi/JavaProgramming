package leetcode;

public class LongestPalindromicSubstring {
    public static String longestPalindrome( String s){
        if(s.isEmpty()) return "";
        int n = s.length();
        boolean [][] palindrome = new boolean[n][n];

            //all substrings of length 1 are always palindrome

        int maxlength=1;
        for(int i=0; i<n; i++){
            palindrome[i][i]=true;
        }
            //substrings of length 2
        int start=0;
        for(int i=0; i<n-1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                palindrome[i][i + 1] = true;
                start = i;
                maxlength = 2;
            }
        }
            //substrings of length greater than 3
            //k is the length of substring
            for(int k= 3 ; k<=n; k++){
                //set the start index
                for(int i=0; i<n-k+1; i++){
                    int j = i+k-1;
                    if(palindrome[i+1][j-1]==true && s.charAt(i)==s.charAt(j)) {
                        palindrome[i][j] = true;
                        if(k>maxlength) {
                            start = i;
                            maxlength = k;
                        }
                    }
                }
            }

        return s.substring(start,start+maxlength);

    }
}
