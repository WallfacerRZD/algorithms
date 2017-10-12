package chapter2_sort.implement;

import utils.util;

public class QuickSort {
	public static void sort(double[] a, int lo, int hi) {
		if (hi <= lo+10) {
			InsertionSort.sort(a, lo, hi);
			return;
		}
		int p = partition(a, lo, hi);
		sort(a, lo, p - 1);
		sort(a, p + 1, hi);
	}

	private static int partition(double[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		double v = a[lo];
		while (true) {
			while (a[++i] < v) {
				if (i >= hi) {
					break;
				}
			}
			while (a[--j] > v) {
				if (j <= lo) {
					break;
				}
			}
			if (j <= i)
				break;
			util.exchange(a, j, i);
		}
		util.exchange(a, lo, j);
		return j;

	}
	
	public static void main(String[] args) {
		double[] test = new double[50000];
		util.makeRandom(test);
		sort(test, 0, test.length-1);
		System.out.println(util.isSorted(test));
		
	}
}
