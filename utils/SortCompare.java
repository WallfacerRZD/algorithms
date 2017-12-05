package utils;

import chapter2_sort.implement.*;

public class SortCompare {
	public static double time(String alg, int[] a) {
		double time1 = System.currentTimeMillis();
		if ("BubbleSort".equals(alg)) {
			BubbleSort.sort(a);
		} else if ("InsertionSort".equals(alg)) {
			InsertionSort.sort(a, 0, a.length-1);
		} else if ("SelectSort".equals(alg)) {
			SelectSort.sort(a);
		} else if ("ShellSort".equals(alg)) {
			ShellSort.sort(a);
		}
		else if("MergeSort".equals(alg)){
			MergeSort.sort(a);
		}
		else if("QuickSort".equals(alg)){
			QuickSort.sort(a);
		}
		else {
			System.out.println("input error");
			return 0;
		}
		double elaspedTime = System.currentTimeMillis() - time1;
		return elaspedTime;
	}

	public static double timeRandomInput(String alg, int N, int size) {
		double total = 0;
		for (int i = 0; i < N; ++i) {
			int[] test = new int[size];
			util.makeRandom(test);
			total += time(alg, test);
		}
		return total;
	}

	public static void main(String[] args) {
////		System.out.println(timeRandomInput("MergeSort", 500, 20000));
////		System.out.println(timeRandomInput("ShellSort", 500, 20000));
//		System.out.println(timeRandomInput("QuickSort", 500, 200000));
		System.out.println(String.format("test %d, %d, test, %d", 1, 2, 3));
	}
}
