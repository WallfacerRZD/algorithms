package chapter2_sort.implement;

import utils.util;

public class QuickSort {
	
	public static void sort(int[] a) {
		sort(a, 0, a.length-1);
//		三向切分快排,对有大量重复主键的数组快20%-30%
//		sort3Way(a, 0, a.length-1);
	}
	
	private static void sort3Way(int[] a, int lo, int hi){
		if(hi <= lo){
			return;
		}
		int i = lo + 1;
		int li = lo;
		int ri = hi;
		int v = a[lo];
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
	
	
	
	private static void sort(int[] a, int lo, int hi) {
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

	private static int partition(int[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		int v = a[lo];
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
		int[] test = new int[500000];
		util.makeRandom(test);
		for(int i = 20000; i < 300000; ++i){
			test[i] = 1;
		}
		double beginTime = System.currentTimeMillis();
		sort(test);
		double endTime = System.currentTimeMillis();
		System.out.println(util.isSorted(test));
		System.out.println(endTime-beginTime);

	}
}
