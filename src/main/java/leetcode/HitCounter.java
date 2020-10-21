package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author shivanidwivedi on 21/10/20
 * @project JavaProgramming
 *
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 *
 * Each function accepts a timestamp parameter (in seconds granularity) and
 * you may assume that calls are being made to the system in chronological order
 * (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.
 *
 * It is possible that several hits arrive roughly at the same time.
 *
 * Example:
 * HitCounter counter = new HitCounter();
 *
 * // hit at timestamp 1.
 * counter.hit(1);
 *
 * // hit at timestamp 2.
 * counter.hit(2);
 *
 * // hit at timestamp 3.
 * counter.hit(3);
 *
 * // get hits at timestamp 4, should return 3.
 * counter.getHits(4);
 *
 * // hit at timestamp 300.
 * counter.hit(300);
 *
 * // get hits at timestamp 300, should return 4.
 * counter.getHits(300);
 *
 * // get hits at timestamp 301, should return 3.
 * counter.getHits(301);
 */


public class HitCounter {
    TreeMap<Integer, Data> map;

    public HitCounter(){
        map = new TreeMap<>();
    }

    public void hit(int timestamp){
        if(map.containsKey(timestamp)){
            Data data = map.get(timestamp);
            data.count++;
            map.put(timestamp, data);
        }else {
            Data data = new Data(timestamp, 1);
            map.put(timestamp, data);
        }
    }

    public int getHits(int timestamp){
        int startTime = timestamp - 300 + 1;
        int count = 0;
        if (map.containsKey(startTime)){
            Data data = map.get(startTime);
            count += data.count;
        }else {
            Map.Entry<Integer, Data> startEntry = map.higherEntry(startTime);
            if (startEntry == null || startEntry.getKey() > timestamp){
                return 0;
            }
            count += startEntry.getValue().count;
            startTime = startEntry.getKey();
        }
        while( startTime <= timestamp ) {
            Map.Entry<Integer, Data> startEntry = map.higherEntry(startTime);
            if( startEntry == null ||  startEntry.getKey()  > timestamp )
                return count;
            count += startEntry.getValue().count;
            startTime = map.higherKey(startTime);
        }
        return count;
    }
}

class Data{
    int timestamp;
    int count;

    public Data(int timestamp, int count){
        this.count = count;
        this.timestamp = timestamp;
    }
}

class HitCounterMain{
    public static void main(String[] args) {
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(1);
        hitCounter.hit(2);
        hitCounter.hit(3);
        System.out.println(hitCounter.getHits(4));
        hitCounter.hit(300);
        System.out.println(hitCounter.getHits(300));
        System.out.println(hitCounter.getHits(301));
    }
}
