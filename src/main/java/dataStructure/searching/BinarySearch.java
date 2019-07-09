package dataStructure.searching;

public class BinarySearch
    {
        public static int search(int[] numbers, int target) {
            int min = 0, max = numbers.length-1;

            while (min <= max) {
                int pos = (min+max) / 2;
                if (numbers[pos] == target) {
                    return pos;
                }
                if (numbers[pos] < target) {
                    min = pos + 1;
                } else {
                    max = pos - 1;
                }
            }

            // +1, because 0 belongs to positive indices
            return -(min+1);
        }

    }
