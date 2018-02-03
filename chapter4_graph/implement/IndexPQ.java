package chapter4_graph.implement;


import java.util.Comparator;
import java.util.PriorityQueue;


public class IndexPQ {

    PriorityQueue<IndexAndWeight> pq;

    public IndexPQ() {
        pq = new PriorityQueue<>(new Comparator<IndexAndWeight>() {
            @Override
            public int compare(IndexAndWeight o1, IndexAndWeight o2) {
                if (o1.weight > o2.weight) {
                    return 1;
                } else if (o1.weight < o2.weight) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }

    public void insert(IndexAndWeight x) {
        pq.offer(x);
    }

    public void change(IndexAndWeight x, double v) {
        x.weight = v;
    }

    public boolean contains(IndexAndWeight x) {
        return pq.contains(x);
    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }

    public IndexAndWeight poll() {
        return pq.poll();
    }

    public void offer(IndexAndWeight x) {
        pq.offer(x);
    }

    public int size() {
        return pq.size();
    }

}
