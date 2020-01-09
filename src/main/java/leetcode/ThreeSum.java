package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<Triplets> threeSum(int[] arr){
        List<Triplets> listOfTriplets = new ArrayList<>();

        //TODO: LOGIC to find triplets---

        //////

        //Create Triplet objects for each triplet
        listOfTriplets.add(new Triplets(1,2,3));
        listOfTriplets.add(new Triplets(6,7,8));


        return listOfTriplets;
    }
}

class Triplets {
    int a, b, c;

    public Triplets(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }


    @Override
    public String toString() {
        return a + " " + b + " " + c;
    }

}
