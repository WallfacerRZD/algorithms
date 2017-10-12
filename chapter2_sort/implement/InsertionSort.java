package chapter2_sort.implement;

import utils.util;
public class InsertionSort {
	public static void sort(double[] a, int lo, int hi){
		for (int i = lo+1; i <= hi; ++i){
			for (int j = i; j > lo && a[j-1] > a[j]; --j){
				util.exchange(a, j, j-1);
			}
		}
	}
	
	public static void main(String[] args){
		double[] test = new double[50000];
		util.makeRandom(test);
		sort(test, 0, test.length-1);
		util.show(test);
		System.out.println(util.isSorted(test));
	}
}
