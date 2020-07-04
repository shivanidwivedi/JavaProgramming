package leetcode;

/**
 * @author shivanidwivedi on 04/07/20
 * @project JavaProgramming
 */
public class ServiceNowSmallestDivisor {
    public static int smallestDivisor(int n){
        if(isPrime(n)){
            return 1;
        }
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return i;
            }else {
                continue;
            }
        }
        return 0;
    }

    private static boolean isPrime(int n){
        boolean flag = false;
        for (int i = 2; i < n/2; i++) {
            if(n % i == 0){
                flag = true;
                break;
            }
        }
        if(!flag){
            return true;
        }
        return false;
    }
}
