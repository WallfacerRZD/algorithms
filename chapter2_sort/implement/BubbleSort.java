package chapter2_sort.implement;

import utils.util;

public class BubbleSort {
	public static void main(String[] args){
		int[] test = new int[2000];
		util.makeRandom(test);
		sort(test);
		util.show(test);
		System.out.println(util.isSorted(test));
	}
	
	public static void sort(int[] a){
		for(int i = a.length-1; i > 0; --i){
			for(int j = 0; j < i; ++j){
				if(a[j] > a[j+1]){
					util.exchange(a, j, j+1);
				}
			}
		}
	}
	
	//此方法不能交换x, y的值
//	private static void exchange(int x, int y){
//		int temp = x;
//		x = y;
//		y = temp;
//	}
	
}
