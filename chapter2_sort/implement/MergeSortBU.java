package chapter2_sort.implement;

import utils.util;
public class MergeSortBU {
	private static int[] temp;

	private static void merge(int[] test, int lo, int mid, int hi) {
		for (int i = lo; i <= hi; ++i) {
			temp[i] = test[i];
		}
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; ++k) {
			if (i > mid) {
				test[k] = temp[j++];
			} else if (j > hi) {
				test[k] = temp[i++];
			} else if (temp[i] < temp[j]) {
				test[k] = temp[i++];
			} else {
				test[k] = temp[j++];
			}
		}
	}

	public static void sort(int[] test) {
		int N = test.length;
		temp = new int[test.length];
		for (int sz = 1; sz < N; sz *= 2) {					//sz:子数组的大小
			for (int lo = 0; lo < N-sz; lo += 2*sz) {		//lo:子数组的索引
				merge(test, lo, lo+sz-1, Math.min(lo+2*sz-1, N-1));
			}
		}
	}
	
	public static void main(String[] args) {
		int[] test = new int[2000];
		util.makeRandom(test);
		sort(test);
		System.out.println(util.isSorted(test));
	}
}
