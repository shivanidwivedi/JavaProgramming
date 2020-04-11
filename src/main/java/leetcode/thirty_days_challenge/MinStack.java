package leetcode.thirty_days_challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 *
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 */
class MinStack {
    private int size = 0;
    List<Integer> minstack;
    public MinStack() {
        minstack = new ArrayList<>();
    }
    public void push(int x) {
        minstack.add(x);

    }

    public int pop() {
        if (minstack.isEmpty()){
            System.out.println("Stack underflow");
            throw new RuntimeException("Stack is empty");
        }else{
            int popValue = minstack.get(minstack.size() - 1);
            minstack.remove(minstack.size()-1);
            size--;
            return popValue;
        }
    }

    public int top() {
        return minstack.get(minstack.size()-1);
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < minstack.size(); i++){
            if(minstack.get(i) <= min) {
                min = minstack.get(i);
            }
        }
        return min;
    }

    public int size(){
        return size;
    }
    @Override
    public String toString(){
        String output = " ";
        for (int x : this.minstack){
            output += " " + x + " ";
        }
        return output;
    }
}

