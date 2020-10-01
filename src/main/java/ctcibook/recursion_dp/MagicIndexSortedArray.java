package ctcibook.recursion_dp;

/**
 * @author shivanidwivedi on 01/10/20
 * @project JavaProgramming
 */
public class MagicIndexSortedArray {
    public static int magicIndex(int[] array){
        return magicIndexSearch(array, 0, array.length-1);
    }

    private static int magicIndexSearch(int[] array, int start, int end){
        if (end < start || start < 0 || end >= array.length){
            return -1;
        }
        int mid = start + (end - start)/2;
        if (array[mid] == mid){
            return mid;
        }
        int leftIndex = Math.min(mid-1, array[mid]);
        int left = magicIndexSearch(array, start, leftIndex);
        if(left >= 0) {
            return left;
        }
        int rightIndex = Math.max(mid + 1, array[mid]);
        int right = magicIndexSearch(array, rightIndex, end);
        return right;
    }

    public static void main(String[] s){
        System.out.println(magicIndex(new int[]{-10,-5,2,2,2,3,4,7,9,12,13}));
    }
}
