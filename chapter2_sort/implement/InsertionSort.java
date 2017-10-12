package chapter2_sort.implement;

import utils.util;
public class InsertionSort {
	public static void sort(double[] a){
		for (int i = 1; i < a.length; ++i){
			for (int j = i; j > 0 && a[j-1] > a[j]; --j){
				util.exchange(a, j, j-1);
			}
		}
	}
	
	public static void main(String[] args){
		double[] test = new double[50000];
		util.makeRandom(test);
		sort(test);
		util.show(test);
		System.out.println(util.isSorted(test));
	}
}
