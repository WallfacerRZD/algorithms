package chapter2_sort.implement;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args){
		int[] test = new int[2000];
		int[] test1 = new int[2000];
		for (int i = 0; i < 2000; ++i){
			test1[i] = test[i] = (int)(Math.random() * 20000);
		}
		sort(test, 0, test.length - 1);
		Arrays.sort(test1);
		
		for(int i = 0; i < test.length; ++i){
			System.out.println(test[i] + "," + test1[i]);
		}
	}
	
	private static void sort(int[] a, int lo, int hi){
		for(int i = hi; i > 0; --i){
			for(int j = 0; j < i; ++j){
				if(a[j] > a[j+1]){
//					exchange(a[j], a[j+1]);
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	//此方法不能交换实参的值
//	private static void exchange(int x, int y){
//		int temp = x;
//		x = y;
//		y = temp;
//	}
	
}
