package utils;

import java.util.Arrays;

public class util {
	public static void show(double[] a){
		for(double i : a){
			System.out.println(i + " ");
		}
 	}
	
	public static boolean isSorted(double[] a){
		for (int i = 0; i < a.length-1; ++i){
			if (a[i] > a[i+1]){
				return false;
			}
		}
		return true;
	}
	
	public static void exchange(double[] a, int i, int j){
		double temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void makeRandom(double[] a){
		for (int i = 0; i < a.length; ++i){
			a[i] = Math.random() * 60000;
		}
//		show(a);
//		System.out.println("---------------------");
	}
}
