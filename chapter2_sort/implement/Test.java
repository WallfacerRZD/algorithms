package chapter2_sort.implement;

import java.util.Arrays;
import java.util.Comparator;

import utils.util;

public class Test {

    public static void sort(int[] a, Comparator c) {
        for (int i = 1; i < a.length; ++i) {
            for (int j = i; j > 0 && less(c, a[j], a[j - 1]); --j) {
                util.exchange(a, j, j - 1);

            }
        }
    }

    private static boolean less(Comparator c, int x, int y) {
        return c.compare(x, y) < 0;
    }

    public static void test(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            System.out.println(i);
            int test = 9;
        }
    }

    public static void main(String[] args) {
        int[] test1 = new int[10];
        sort(test1, new reverseComparator());
        test(test1);

    }

    public static class reverseComparator implements Comparator<Integer> {
        public int compare(Integer x, Integer y) {
            return y - x;
        }
    }
}
