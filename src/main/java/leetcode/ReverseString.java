package leetcode;

public class ReverseString {
    public static char[] reverseStr(char [] arr){
        int left= 0, right = arr.length-1;
       // if(arr.length==0) return arr;
       // if(arr.length==1) return arr;

        while(left < right){

            char temp = arr[left];
            arr[left]=arr[right];
            arr[right]= temp;
            left++;
            right--;

        }
        return arr;
    }
}
