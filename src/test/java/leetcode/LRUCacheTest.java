package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void LRUCache_test(){
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.get(3);
        lruCache.put(4,4);

        Assert.assertEquals("1 is least recently used","{2=2, 3=3, 4=4}",lruCache.toString());

        lruCache.get(2);
        Assert.assertEquals("1 is LRU","{3=3, 4=4, 2=2}",lruCache.toString());

        lruCache.get(2);
        lruCache.put(10,10);
        Assert.assertEquals("10 is added","{4=4, 2=2, 10=10}",lruCache.toString());

        lruCache.get(10);
        lruCache.put(-1,-1); //removed 4
        lruCache.get(4); //returned null
        Assert.assertEquals("10 is added","{2=2, 10=10, -1=-1}",lruCache.toString());
    }
}
