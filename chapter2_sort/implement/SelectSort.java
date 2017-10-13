package chapter2_sort.implement;

import utils.util;

public class SelectSort {
	public static void main(String[] args) {
		int length = 20000;
		int[] test = new int[length];
		util.makeRandom(test);
		sort(test);
		util.show(test);
		System.out.println(util.isSorted(test));

	}

	public static void sort(int[] a) {
		for (int i = 0; i < a.length; ++i) {
			int min = i;
			for (int j = min + 1; j < a.length; ++j) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			if (min != i) {
				util.exchange(a, min, i);
			}
		}
	}

}
