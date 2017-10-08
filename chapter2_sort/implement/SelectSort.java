package chapter2_sort.implement;


public class SelectSort {
	public static void main(String[] args){
		int length = 20000;
		int[] test = new int[length];
		for (int i = 0; i < length; ++i) {
			test[i] = (int)( Math.random() * 100);
		}
		
		sort(test, 0, test.length-1);
		
		for (int i = 0; i < length; ++i) {
			System.out.println(test[i]);
		}
	}
	
	private static void sort(int[] a, int lo, int hi){
		for (int i = lo; i <= hi; ++i) {
			int min = i;
			for (int j = min+1; j <= hi; ++j){
				if (a[j] < a[min]) {
					min = j;
				}
			}
			if (min != i){
				exchange(a, min, i);
			}
		}
	}
	
	private static void exchange(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
