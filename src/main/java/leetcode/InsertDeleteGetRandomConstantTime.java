package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author shivanidwivedi on 24/08/20
 * @project JavaProgramming
 *
 * Design a data structure that supports all following operations in average O(1) time.
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements
 * (it's guaranteed that at least one element exists when this method is called).
 * Each element must have the same probability of being returned.
 *
 * Example:
 *
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 */
public class InsertDeleteGetRandomConstantTime {
    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random rand = new Random();

    public InsertDeleteGetRandomConstantTime() {
        map = new HashMap<>();
        list = new ArrayList();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int lastElement = list.get(list.size()-1);
        int index = map.get(val);
        list.set(index, lastElement);
        map.put(lastElement, index);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
