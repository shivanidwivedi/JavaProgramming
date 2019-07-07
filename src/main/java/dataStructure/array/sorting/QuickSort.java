package dataStructure.array.sorting;

// Quick Sort algorithm

public class QuickSort {
    static int[] sort(int[] arr) {

        sortUtil(arr, 0, arr.length - 1);
        return arr;

}
    private static void sortUtil(int[] arr, int low, int high) {

        if (low < high) {
            int pivot = partition(arr, low, high);

            sortUtil(arr, low, pivot - 1);
            sortUtil(arr, pivot + 1, high);
        }

    }
// Partition method
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int movingIndex = -1; //this needs to point to bigger element

        /**
         * Moving index will move iff there is a smaller value than pivot,
         * else it will stay
         *
         * Once smaller value is found, movingIndex+1 will be swapped with current element
         */
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] <= pivot) {
                movingIndex++; //if there is no larger element encountered till now, swap will have no effect

                int temp = arr[i];
                arr[i] = arr[movingIndex];
                arr[movingIndex] = temp;
            }
        }
        return movingIndex;
    }
}

