package chapter1_Fundamentals.implement;

import java.util.Iterator;


public class MyStack<Item> implements Iterable<Item> {
	private int N = 0;
	private Item[] elements = (Item[])new Object[1];
	public boolean isFull()   {return N == elements.length;}
	public boolean isEmpty() {return N == 0;}
	public int size() 		   {return N;}
	private void resize(int max){
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; ++i){
			temp[i] = elements[i];
		}
		elements = temp;
	}
	public void push(Item item){
		if (isFull()){
			resize(elements.length * 2);
		}
		elements[N++] = item;                      
	}
	public Item pop() {
		if (!isEmpty()) {
			Item top = elements[--N];
			elements[N] = null;
			// N为0时,resize会导致数组为空
			if (N > 0 && N == elements.length / 4) {resize(elements.length / 2);}
			return top;
		}
		else{
			System.out.println("the stack is empty!!");
			return null;
		}
	}
	
	public Iterator<Item> iterator(){
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>{
		private int i = N;
		public boolean hasNext() {return i > 0;}
		public Item next() {return elements[--i];}
		public void remove() { }
	}
	
}
