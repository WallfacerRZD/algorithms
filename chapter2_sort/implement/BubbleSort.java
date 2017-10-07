package chapter2_sort.implement;

public class BubbleSort {
	public static void main(String[] args){
		int[] test = new int[2000];
		for (int i = 0; i < 2000; ++i){
			test[i] = (int)(Math.random() * 200);
		}
		
		sort(test, 0, test.length);
		for(int i = 0; i < test.length; ++i){
			System.out.println(test[i]);
		}
	}
	
	private static void sort(int[] a, int lo, int hi){
		for(int i = hi - 1; i > 0; --i){
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
	
	private static void exchange(int x, int y){
		int temp = x;
		x = y;
		y = temp;
	}
	
}
