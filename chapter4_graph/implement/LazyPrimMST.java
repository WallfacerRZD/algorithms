package chapter4_graph.implement;

import utils.In;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 */
public class LazyPrimMST {
    private boolean[] marked;
    private Queue<Edge> mst;
    private PriorityQueue<Edge> pq;

    public LazyPrimMST(EdgeWeightGraph g) {
        pq = new PriorityQueue<>();
        marked = new boolean[g.getV()];
        mst = new LinkedList<>();
        visit(g, 0);
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) {
                continue;
            }
            mst.offer(e);
            if (!marked[v]) {
                visit(g, v);
            }
            if (!marked[w]) {
                visit(g, w);
            }
        }
    }

    private void visit(EdgeWeightGraph g, int v) {
        marked[v] = true;
        for (Edge e : g.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.offer(e);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public static void main(String[] args) {
        In in = new In("../algs4-data/mediumEWG.txt");
        EdgeWeightGraph testGraph = new EdgeWeightGraph(in);
        LazyPrimMST test = new LazyPrimMST(testGraph);
        for (Edge e : test.edges()) {
            System.out.println(e);
        }
    }
}
