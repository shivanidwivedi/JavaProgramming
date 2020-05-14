package leetcode.bit_manipulation;

/**
 * @author shivanidwivedi on 14/05/20
 * @project JavaProgramming
 */
public class StepsReduceToZero {
    public static int numberOfSteps (int num) {
        if(num == 0) return 0;
        int steps = 0;
        while(num > 0){
            if(num % 2 == 0){
                num /= 2;
                steps++;
            } else{
                num -= 1;
                steps++;
            }
        }
        return steps;
    }
}
