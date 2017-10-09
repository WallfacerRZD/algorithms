package chapter1_Fundamentals.implement;


public class test {
	public static void main(String[] args){
		MyStack<Integer> stack = new MyStack();
		for (int i = 0; i < 10; ++i) {
			stack.push(i);
		}
		for (int i : stack){
			System.out.println(i);
		}
		for (int i = 0; i < 12; ++i){
			stack.pop();
		}
	}
}
