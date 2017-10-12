package utils;

import chapter2_sort.implement.*;

public class SortCompare {
	public static double time(String alg, double[] a) {
		double time1 = System.currentTimeMillis();
		if (alg.equals("BubbleSort")) {
			BubbleSort.sort(a);
		} else if (alg.equals("InsertionSort")) {
			InsertionSort.sort(a, 0, a.length);
		} else if (alg.equals("SelectSort")) {
			SelectSort.sort(a);
		} else if (alg.equals("ShellSort")) {
			ShellSort.sort(a);
		}
		else if(alg.equals("MergeSort")){
			MergeSort.sort(a);
		}
		else if(alg.equals("QuickSort")){
			QuickSort.sort(a, 0, a.length-1);
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
			double[] test = new double[size];
			util.makeRandom(test);
			total += time(alg, test);
		}
		return total;
	}

	public static void main(String[] args) {
		System.out.println(timeRandomInput("MergeSort", 5000, 20000));
		System.out.println(timeRandomInput("ShellSort", 5000, 20000));
		System.out.println(timeRandomInput("QuickSort", 5000, 20000));
	}
}
