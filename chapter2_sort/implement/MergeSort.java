package chapter2_sort.implement;

import utils.util;

public class MergeSort {
	private static int[] temp;

	private static void merge(int[] a, int lo, int mid, int hi) {
		for (int i = lo; i <= hi; ++i) {
			temp[i] = a[i];
		}
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; ++k) {
			if (i > mid) {
				a[k] = temp[j++];
			} else if (j > hi) {
				a[k] = temp[i++];
			} else if (temp[i] <= temp[j]) {			//保持算法稳定性
				a[k] = temp[i++];
			} else {
				a[k] = temp[j++];
			}
		}
	}

	private static void sort(int[] a, int lo, int hi) {
		if (hi <= lo) {
            return;
        }
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		if (a[mid] > a[mid+1]) {
			merge(a, lo, mid, hi);
		}
	}

	public static void sort(int[] a) {
		temp = new int[a.length];
		sort(a, 0, a.length - 1);
	}
	
	public static void main(String[] args){
		int[] test = new int[2000];
		util.makeRandom(test);
		sort(test);
		System.out.println(util.isSorted(test));
	}
}
