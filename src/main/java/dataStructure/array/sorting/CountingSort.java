package dataStructure.array.sorting;

/*
Consider the data in the range 0 to 9.
Input data: 1, 4, 1, 2, 7, 5, 2
  1) Take a count array to store the count of each unique object.
  Index:     0  1  2  3  4  5  6  7  8  9
  Count:     0  2  2  0   1  1  0  1  0  0

  2) Modify the count array such that each element at each index
  stores the sum of previous counts.
  Index:     0  1  2  3  4  5  6  7  8  9
  Count:     0  2  4  4  5  6  6  7  7  7

The modified count array indicates the position of each object in
the output sequence.

  3) Output each object from the input sequence followed by
  decreasing its count by 1.
  Process the input data: 1, 4, 1, 2, 7, 5, 2. Position of 1 is 2.
  Put data 1 at index 2 in output. Decrease count by 1 to place
  next data 1 at an index 1 smaller than this index.
 */

public class CountingSort {
    public static int[] sort(int arr[]) {
        int n = arr.length;
        //boundary conditions
        if (arr == null) {
            return null;
        } else if (arr.length == 1) {
            return arr;
        } else {
            // The output integer array that will have sorted array
            int output[] = new int[n];

            // Create a count array to store count of individual
            // integer and initialize count array as 0
            int count[] = new int[256];
            for (int i = 0; i < 256; ++i)
                count[i] = 0;

            // store count of each integer
            for (int i = 0; i < n; i++)
                ++count[arr[i]];

            // Change count[i] so that count[i] now contains actual
            // position of this integer in output array
            for (int i = 1; i <= 255; ++i)
                count[i] += count[i - 1];

            // Build the output integer array
            // To make it stable we are operating in reverse order.
            for (int i = n - 1; i >= 0; i--) {
                output[count[arr[i]] - 1] = arr[i];
                --count[arr[i]];
            }

            // Copy the output array to arr, so that arr now
            // contains sorted integers
            for (int i = 0; i < n; ++i)
                arr[i] = output[i];
            return arr;
        }

    }   }