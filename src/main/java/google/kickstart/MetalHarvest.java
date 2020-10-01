package google.kickstart;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author shivanidwivedi on 26/09/20
 * @project JavaProgramming
 */
public class MetalHarvest {
    public static int getRobotsCount(int[][] time, int duration) {
        int count = 1;
        List<Interval> intervals = initializeIntervals(time);
        int currTime = intervals.get(0).start;
        int max = intervals.get(intervals.size()-1).end;

        for(int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            int travelTime = currTime+duration;
            if(travelTime > max) {
                //count++;
                break;
            }
            if(interval.start > travelTime) {
                //if last interval
                if(i == intervals.size()-1) {
                    count += Math.ceil((double)(interval.end - interval.start) / duration);
                    break;
                }
                count++;
                currTime = interval.start;
            } else if(interval.end > travelTime) {
                int temp = (int) Math.ceil((double)(interval.end - travelTime) / duration);
                count += Math.ceil((double)(interval.end - travelTime) / duration);
                currTime =  (duration*temp);
            }
        }

        return count;
    }

    private static List<Interval> initializeIntervals(int[][] arr) {
        List<Interval> intervals = new ArrayList<>();
        for(int[] currInterval : arr) {
            intervals.add(new Interval(currInterval));
        }
        Collections.sort(intervals);
        return intervals;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for(int i=1; i<=count; i++) {
            int size = in.nextInt();
            int duration = in.nextInt();
            int[][] arr = new int[size][2];
            for(int j=0; j<size; j++) {
                arr[j][0] = in.nextInt();
                arr[j][1] = in.nextInt();
            }
            System.out.println("Case #"+i+": "+getRobotsCount(arr, duration));
        }

    }
}

class Interval implements Comparable<Interval>{
    int start, end;

    public Interval(int[] interval) {
        this.start = interval[0];
        this.end = interval[1];
    }

    @Override
    public int compareTo(Interval o) {
        if(this.start == o.start) {
            return 0;
        } else if(this.start < o.start) {
            return -1;
        } else {
            return 1;
        }
    }

    public int compare(int time) {
        if(time > this.end) {
            return -1;
        } else if (time < this.start) {
            return 1;
        } else if (time >= this.start && time <= this.end) {
            return 0;
        }
        return -1;
    }
}
