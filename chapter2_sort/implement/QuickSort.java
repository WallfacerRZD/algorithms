package chapter2_sort.implement;

import utils.util;

public class QuickSort {
	
	public static void sort(double[] a) {
		sort(a, 0, a.length-1);
		//三向切分快排
//		sort3Way(a, 0, a.length-1);
	}
	
	private static void sort3Way(double[] a, int lo, int hi){
		if(hi <= lo){
			return;
		}
		int i = lo + 1;
		int li = lo;
		int ri = hi;
		double v = a[lo];
		while(i <= ri){
			if(a[i] > v) {
				util.exchange(a, i, ri--);
			}
			else if(a[i] < v){
				util.exchange(a, i++, li++);
			}
			else{
				i++;
			}
		}
		//a[lo..li-1] < v = a[li..ri] < a[ri+1..hi]达成
		sort3Way(a, lo, li-1);
		sort3Way(a, ri+1, hi);
	}
	
	
	
	private static void sort(double[] a, int lo, int hi) {
		//数组较小时用插入排序
//		if (hi <= lo + 10) {
//			InsertionSort.sort(a, lo, hi);
//			return;
//		}
		if (hi <= lo) {
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
		sort(test);
		System.out.println(util.isSorted(test));

	}
}
