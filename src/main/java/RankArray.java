
import java.util.*;

/**
 * @author shivanidwivedi on 18/08/20
 * @project JavaProgramming
 */
public class RankArray {
    public static List<Integer> rankArray(List<List<String>> reviews, String[] goodWords){
        List<Integer> result = new ArrayList<>();

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < goodWords.length; i++){
            set.add(goodWords[i]);
        }

        TreeMap<Integer, Integer> reviewsCount = new TreeMap<>();
        for(int i = 0; i < reviews.size(); i++){
            List<String> currentReview = reviews.get(i);
            int count = countGoodWords(currentReview,set);
            reviewsCount.put(i,count);
        }
        TreeMap<Integer, Integer> sortedMap = sortByValue(reviewsCount);
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()){
            if (entry.getValue() != 0){
                result.add(entry.getKey());
            }
        }
        return result;
    }

    private static int countGoodWords(List<String> currentReview, HashSet<String> set){
        int count = 0;
        for (int i = 0; i < currentReview.size(); i++){
            if (set.contains(currentReview.get(i)));
            count++;
        }
        return count;
    }

    public static TreeMap<Integer, Integer> sortByValue(TreeMap<Integer, Integer> unsortedMap) {
        TreeMap<Integer, Integer> sortedMap = new TreeMap(new ValueComparator(unsortedMap));
        sortedMap.putAll(unsortedMap);
        return sortedMap;
    }
}
class ValueComparator implements Comparator {
    TreeMap<Integer, Integer> map;

    public ValueComparator(TreeMap<Integer, Integer> map) {
        this.map = map;
    }

    public int compare(Object keyA, Object keyB) {
        Comparable valueA = (Comparable) map.get(keyA);
        Comparable valueB = (Comparable) map.get(keyB);
        return valueB.compareTo(valueA);
    }
}