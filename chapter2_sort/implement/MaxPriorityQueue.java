package chapter2_sort.implement;

import utils.util;

public class MaxPriorityQueue {
	private int[] pq;
	private int N = 0;

	public MaxPriorityQueue(int maxN) {
		pq = new int[maxN + 1];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void insert(int i) {
		pq[++N] = i;
		swim(N);
	}

	public int delMax() {
		int max = pq[1];
		util.exchange(pq, 1, N--);
		sink(1);
		return max;

	}

	private boolean less(int i, int j) {
		return pq[i] < pq[j];
	}

	private void swim(int i) {
		while (i > 1 && less(i / 2, i)) {
			util.exchange(pq, i, i / 2);
			i = i / 2;
		}
	}

	private void sink(int i) {
		while (2 * i <= N) {
			int k = i * 2;
			if (k < N && less(k, k + 1)) {
				k++;
			}
			if (less(i, k)) {
				util.exchange(pq, i, k);
				i = k;
			} else {
				break;
			}
		}

	}

	public static void main(String[] args) {
		MaxPriorityQueue queue = new MaxPriorityQueue(20);
		for (int i = 0; i < 10; i++) {
			queue.insert(i);
		}
		for (int i = 0; i < 10; ++i) {
			System.out.println(queue.delMax());
		}
	}
}
