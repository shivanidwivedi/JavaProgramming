package dataStructure.hashmap;

import lombok.Getter;

import java.util.HashMap;

/**
 * Example of simple hashmap with string/Integer as keys
 * @author gaganmani
 * @date 05/10/19
 * @package dataStructure.hashmap
 */
@Getter
public class SimpleHashMap {
     HashMap<String, Integer> demoHashMap;

    /**
     *
     * @param key
     * @param value
     */
    public void addValues(String key, Integer value){
        if(demoHashMap == null) {
            demoHashMap = new HashMap<String, Integer>();
        }
        /**
         * 1. Find bucket for key.hashcode(), if not found then create new bucket
         * 2. Once bucket is found, searches for same key (if present)
         * by using key.equals(otherKey)
         * 3. If equals() matches with a key, then replace it.
         * 4. Otherwise, add one more entry in the same bucket [linkedList].
         */
        demoHashMap.put(key, value);
    }
}
