package chapter2_sort.implement;

import utils.util;

public class ShellSort {
	public static void main(String[] args) {
		int[] test = new int[2000];
		util.makeRandom(test);
		sort(test);
		System.out.println(util.isSorted(test));
	}
	
	public static void sort(int[] a) {
		int N = a.length;
		int h = 1;
		while (h < N/3) {
			h = 3 * h + 1;
		}
		while (h >= 1) {
			for (int i = h; i < N; ++i) {
				for (int j = i; j >= h && a[j-h] > a[j]; j -= h) {
					util.exchange(a, j, j-h);
				}
			}
			h /= 3;
		}
	}
}
