package chapter2_sort.implement;

import utils.util;

public class HeapSort {
	public static void sort(int[] a) {
		int N = a.length - 1;
		for (int k = N / 2; k >= 1; --k) {
			sink(a, k, N);
		}
		while (N > 0) {
			exchange(a, 1, N--);
			sink(a, 1, N);
		}

	}

	private static void exchange(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static void sink(int[] a, int i, int N) {
		while (2 * i <= N) {
			int k = 2 * i;
			if (k < N && a[k] < a[k + 1]) {
				k++;
			}
			if (a[i] >= a[k]) {
				break;
			} else {
				exchange(a, k, i);
				i = k;
			}
		}
	}

	public static void main(String[] args) {
		int[] test = new int[200000];
		int N = 500;
		double total = 0;
		for (int i = 0; i < N; ++i) {
			util.makeRandom(test);
			double beginTime = System.currentTimeMillis();
			sort(test);
			double endTime = System.currentTimeMillis();
			total += endTime - beginTime;
		}
		System.out.print(total);
	}
}
