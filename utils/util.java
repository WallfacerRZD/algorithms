package utils;


public class util {
	public static void show(int[] test){
		for(int i : test){
			System.out.println(i + " ");
		}
 	}
	
	public static boolean isSorted(int[] a){
		for (int i = 0; i < a.length-1; ++i){
			if (a[i] > a[i+1]){
				return false;
			}
		}
		return true;
	}
	
	public static void exchange(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void makeRandom(int[] test){
		for (int i = 0; i < test.length; ++i){
			test[i] = (int) (Math.random() * 60000);
		}
//		show(test);
//		System.out.println("---------------------");
	}
}
