package chapter2_sort.implement;

import utils.util;
public class MergeSortBU {
	private static double[] temp;

	private static void merge(double[] a, int lo, int mid, int hi) {
		for (int i = lo; i <= hi; ++i) {
			temp[i] = a[i];
		}
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; ++k) {
			if (i > mid) {
				a[k] = temp[j++];
			} else if (j > hi) {
				a[k] = temp[i++];
			} else if (temp[i] < temp[j]) {
				a[k] = temp[i++];
			} else {
				a[k] = temp[j++];
			}
		}
	}

	public static void sort(double[] a) {
		int N = a.length;
		temp = new double[a.length];
		for (int sz = 1; sz < N; sz *= 2) {					//sz:子数组的大小
			for (int lo = 0; lo < N-sz; lo += 2*sz) {		//lo:子数组的索引
				merge(a, lo, lo+sz-1, Math.min(lo+2*sz-1, N-1));
			}
		}
	}
	
	public static void main(String[] args) {
		double[] test = new double[2000];
		util.makeRandom(test);
		sort(test);
		System.out.println(util.isSorted(test));
	}
}
