package dataStructure.misc;

/**
 * @author shivanidwivedi on 05/04/20
 * @project JavaProgramming
 * GCD of more than two (or array) numbers
 */
public class GCD {
    public static int findGcd(int arr[], int num){
        int result = arr[0];
        for (int i = 1; i < num; i++){
            result = gcd(arr[i], result);
            if (result == 1){
                return 1;
            }
        }
        return result;
    }
    private static int gcd(int a, int b){
        if (a == 0) return b;
       return gcd(b % a, a);
    }
}
