package GPrep;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shivanidwivedi on 30/03/21
 * @project JavaProgramming
 * You're given a list of tasks, and a cool down time between the same types of tasks.
 * The only difference is that you cannot change the order of the tasks,
 * so you need to calculate the time to complete the tasks based on the string given.
 *
 * i.e. Example : "ABACCA", cooldown = 2 would return a total time of 9
 */
public class TaskSchedulerModified {
    public int totalTime(char[] tasks, int n){
        Map<Character, Integer> map = new HashMap<>();
        int currentTime = 0;
        for(char ch : tasks){
            if (map.containsKey(ch)){
                if(currentTime-map.get(ch) <= n){
                    currentTime += n - (currentTime - map.get(ch) + 1);
                }
            }
            map.put(ch, currentTime);
            currentTime++;
        }
        return currentTime;
    }

    public static void main(String[] args) {
        TaskSchedulerModified obj = new TaskSchedulerModified();
        Assert.assertEquals(9, obj.totalTime(new char[]{'A','B','A','C','C','A'}, 2));
    }
}
