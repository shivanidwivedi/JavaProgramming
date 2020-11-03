package dataStructure.random;

import java.util.*;

/**
 * @author shivanidwivedi on 30/10/20
 * @project JavaProgramming
 */
public class ArrayComparison {
    public boolean areSame(char[] arr1, char[] arr2, char[] ignoreArray) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        HashSet<Character> setIgnore = new HashSet<>();
        for (char ch : ignoreArray) {
            setIgnore.add(ch);
        }
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        for (char ch : arr1) {
            if (!setIgnore.contains(ch)) {
                list1.add(ch);
            }
        }
        for (char ch : arr2) {
            if (!setIgnore.contains(ch)) {
                list2.add(ch);
            }
        }
        if (list1.size() != list2.size()) {
            return false;
        } else {
            return list1.equals(list2);
        }
    }

    public boolean areSameArrays(char[] arr1, char[] arr2, char[] ignoreArray) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        HashSet<Character> setIgnore = new HashSet<>();
        for (char ch : ignoreArray) {
            setIgnore.add(ch);
        }
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] != arr2[j] && !setIgnore.contains(arr1[i]) && !setIgnore.contains(arr2[j])) {
                return false;
            } else if (arr1[i] != arr2[j] && setIgnore.contains(arr1[i]) && !setIgnore.contains(arr2[j])) {
                i++;
            } else if (arr1[i] != arr2[j] && !setIgnore.contains(arr1[i]) && setIgnore.contains(arr2[j])) {
                j++;
            } else {
                i++;
                j++;
            }
        }
        while (i < arr1.length) {
            if (!setIgnore.contains(arr1[i])) {
                return false;
            }
            i++;
        }
        while (j < arr2.length) {
            if (!setIgnore.contains(arr2[j])) {
                return false;
            }
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayComparison arrayComparison = new ArrayComparison();
        System.out.println(arrayComparison.areSame(new char[]{'a', 'b'}, new char[]{'a', 'b'}, new char[]{}));
        System.out.println(arrayComparison.areSame(new char[]{'a', 'b'}, new char[]{'b', 'b'}, new char[]{}));
        System.out.println(arrayComparison.areSame(new char[]{'a', 'b'}, new char[]{'b', 'a'}, new char[]{'b'}));
        System.out.println(arrayComparison.areSame(new char[]{'a', 'b'}, new char[]{'a', 'c'}, new char[]{'b', 'c'}));
        System.out.println(arrayComparison.areSame(new char[]{'a', 'c', 'b'}, new char[]{'b', 'c', 'a'}, new char[]{'b'}));

        System.out.println(arrayComparison.areSameArrays(new char[]{'a', 'b'}, new char[]{'a', 'b'}, new char[]{}));
        System.out.println(arrayComparison.areSameArrays(new char[]{'a', 'b'}, new char[]{'b', 'b'}, new char[]{}));
        System.out.println(arrayComparison.areSameArrays(new char[]{'a', 'b'}, new char[]{'b', 'a'}, new char[]{'b'}));
        System.out.println(arrayComparison.areSameArrays(new char[]{'a', 'b'}, new char[]{'a', 'c'}, new char[]{'b', 'c'}));
        System.out.println(arrayComparison.areSameArrays(new char[]{'a', 'c', 'b'}, new char[]{'b', 'c', 'a'}, new char[]{'b'}));
        System.out.println(arrayComparison.areSameArrays(new char[]{'c', 'c', 'a', 'c', 'b', 'b', 'b'}, new char[]{'c', 'b', 'c', 'a', 'c'}, new char[]{'b'}));
        System.out.println(arrayComparison.areSameArrays(new char[]{'a', 'c', 'b', 'e'}, new char[]{'b', 'c', 'a'}, new char[]{'b'}));

        System.out.println(arrayComparison.areSameCommutative(new char[]{'a', 'b'}, new char[]{'a', 'b'}, new char[]{}));
        System.out.println(arrayComparison.areSameCommutative(new char[]{'a', 'b'}, new char[]{'b', 'b'}, new char[]{}));
        System.out.println(arrayComparison.areSameCommutative(new char[]{'a', 'b'}, new char[]{'b', 'a'}, new char[]{'b'}));
        System.out.println(arrayComparison.areSameCommutative(new char[]{'a', 'b'}, new char[]{'a', 'c'}, new char[]{'b', 'c'}));
        System.out.println(arrayComparison.areSameCommutative(new char[]{'a', 'c', 'b'}, new char[]{'b', 'c', 'a'}, new char[]{'b'}));
        System.out.println(arrayComparison.areSameCommutative(new char[]{'c', 'c', 'a', 'c', 'b', 'b', 'b'}, new char[]{'c', 'b', 'c', 'a', 'c'}, new char[]{'b'}));
        System.out.println(arrayComparison.areSameCommutative(new char[]{'a', 'c', 'b'}, new char[]{'b', 'c', 'a'}, new char[]{'b'}));
    }

    //if commutative is considered to be same
    public boolean areSameCommutative(char[] arr1, char[] arr2, char[] ignoreArray) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        HashSet<Character> setIgnore = new HashSet<>();
        for (char ch : ignoreArray) {
            setIgnore.add(ch);
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : arr1) {
            if (!setIgnore.contains(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        for (char ch : arr2) {
            if (!setIgnore.contains(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) - 1);
            }
        }
        for (int val : map.values()) {
            if (val > 0) {
                return false;
            }
        }
        return true;
    }
}
