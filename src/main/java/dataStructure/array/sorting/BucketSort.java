package dataStructure.array.sorting;
/*
        Input:
        A list of unsorted data: 0.25 0.36 0.58 0.41 0.29 0.22 0.45 0.79 0.01 0.69
        Array before Sorting: 0.25 0.36 0.58 0.41 0.29 0.22 0.45 0.79 0.01 0.69

        Output:
        Array after Sorting: 0.01 0.22 0.25 0.29 0.36 0.41 0.45 0.58 0.69 0.79
*/

public class BucketSort {
    public static int[] sort(int[] arr, int maxVal) {
        int[] bucket = new int[maxVal + 1];

        //boundary conditions
        if(arr == null){
            return null;
        }
        else if(arr.length == 1){
            return arr;
        }
        else {
            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = 0;
            }

            for (int i = 0; i < arr.length; i++) {
                bucket[arr[i]]++;
            }

            int outPos = 0;
            for (int i = 0; i < bucket.length; i++) {
                for (int j = 0; j < bucket[i]; j++) {
                    arr[outPos++] = i;
                }
            }
            return arr;
        }
    }
}