package leetcode.thirty_days_challenge;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 10/04/20
 * @project JavaProgramming
 */
public class MinStackTest {

    @Test
    public void pop() {

    }
    @Test
    public void addString(){
        MinStack minStack = new MinStack();
        minStack.push(4);
        System.out.println(minStack);
        minStack.pop();
        System.out.println(minStack);
        for(int i = 4; i < 20; i++){
            minStack.push(i);
        }
        System.out.println(minStack);
    }
}