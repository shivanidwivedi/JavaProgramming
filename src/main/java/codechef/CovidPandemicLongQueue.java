package codechef;

/**
 * @author shivanidwivedi on 12/04/20
 * @project JavaProgramming
 * Due to the COVID pandemic, people have been advised to stay at least 6 feet away from any other person. Now, people are lining up in a queue at the local shop and it is your duty to check whether they are all following this advice.
 *
 * There are a total of N spots (numbered 1 through N) where people can stand in front of the local shop. The distance between each pair of adjacent spots is 1 foot. Each spot may be either empty or occupied; you are given a sequence A1,A2,…,AN, where for each valid i, Ai=0 means that the i-th spot is empty, while Ai=1 means that there is a person standing at this spot. It is guaranteed that the queue is not completely empty.
 *
 * For example, if N=11 and the sequence A is (0,1,0,0,0,0,0,1,0,0,1), then this is a queue in which people are not following the advice because there are two people at a distance of just 3 feet from each other.
 *
 * You need to determine whether the people outside the local shop are following the social distancing advice or not. As long as some two people are standing at a distance smaller than 6 feet from each other, it is bad and you should report it, since social distancing is not being followed.
 */
//TC: o(n), SC: O(1)
public class CovidPandemicLongQueue {
    public static String covidPandemic(int[] longQueue){
        int indexOfOne = -1;
        for (int i = 0; i < longQueue.length; i++){
            if (longQueue[i] == 1){
                if (indexOfOne != -1 && Math.abs(i-indexOfOne) < 6){
                    return "NO";
                }
                indexOfOne = i;
            }
        }
        return "YES";
    }
}
