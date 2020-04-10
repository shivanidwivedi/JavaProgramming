package leetcode;

//import java.lang.reflect.Array;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @author shivanidwivedi on 09/04/20
 * @project JavaProgramming
 */
public class TopToys {
    public static ArrayList<String> populateNToys(int topToys, List<String> toys, List<String> quotes) {
        List<Toy> toyOccurence = new ArrayList<>();
        for(String toy : toys){
            int toyCount = 0;
            for (String quote : quotes){
                toyCount += getOccurence(toy,quote);
            }
            toyOccurence.add(new Toy(toy, toyCount));
        }
        Collections.sort(toyOccurence,new ToyComparator());
        return getTopNToys(topToys, toyOccurence);
    }
    static int getOccurence(String toy, String sentence){
        String[] sentenceArray = sentence.split(" ");
        int count = 0;
        for (String word : sentenceArray){
            if (count == 1) break;
            if (toy.equals(word)){
                count++;
            }
        }
        return count;
    }

    static ArrayList<String> getTopNToys(int topN, List<Toy> toyOccurence) {
        ArrayList<String> toys = new ArrayList<>();
        int count =0;
        for (Toy toy : toyOccurence){
            if (count == topN) break;
            count++;
            if (toy.count > 0){
                toys.add(toy.toyName);
            }
        }
        return toys;
    }
}
class Toy {
    String toyName;
    int count;
    public Toy(String toyName, int count){
        this.toyName = toyName;
        this.count = count;
    }
}
class ToyComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy t1, Toy t2){
        if (t1.count == t2.count){
            return t1.toyName.compareTo(t2.toyName);
        }
        return t2.count - t1.count;
    }
}


