// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.Arrays;
import java.util.*;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int k)
    {
        List<Integer> output = new ArrayList();
        if(states.length == 1){
            if(k%2 == 0){
                states[0] = 1;
            }
            else {
                states[0] = 0;
            }

        }
        else{
            // WRITE YOUR CODE HERE
            while(k-- != 0){
                //for 1 day
                states = oneDayChange(states);
            }
        }

        return arrayToList(states);
    }

    private int[] oneDayChange(int[] states) {
        int[] outArr = new int[states.length];
        for(int i = 0; i < states.length; i++) {
            if(i == 0) {
                outArr[i] = xor(0, states[i+1]);
            }
            else if( i == states.length - 1) {
                outArr[i] = xor(states[i-1], 0);

            }
            else{
                outArr[i] = xor(states[i-1], states[i+1]);
            }

        }
        states = Arrays.copyOf(outArr, outArr.length);
        return states;
    }

    private int xor(int a, int b) {
        return a^b;
    }

    private List<Integer> arrayToList(int[] states){
        List<Integer> output = new ArrayList<>();
        for(int state : states) {
            output.add(state);
        }
        return output;
    }
    // METHOD SIGNATURE ENDS
}