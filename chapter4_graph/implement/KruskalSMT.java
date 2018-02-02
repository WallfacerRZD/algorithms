package chapter4_graph.implement;

import chapter1_Fundamentals.implement.UF;
import utils.In;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Kruskal 算法寻找最小生成树
 * 空间复杂度O(E), 时间复杂度O(ElogE)
 *
 * 将所有边添加到优先队列
 * 每次取出一条边添加到最小生成树队列(避圈)
 * 用并查集检测是否形成圈.
 *
 * @date 2018/2/2
 */
public class KruskalSMT {
    private Queue<Edge> smt;

    public KruskalSMT(EdgeWeightGraph g) {
        PriorityQueue<Edge> edges = new PriorityQueue<>();
        smt = new LinkedList<>();
        UF uf = new UF(g.getV());
        for (Edge e : g.edges()) {
            edges.offer(e);
        }

        while (!edges.isEmpty() && smt.size() < g.getV() - 1) {
            Edge e = edges.poll();
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) {
                continue;
            }
            smt.offer(e);
            uf.union(v, w);
        }
    }

    public Iterable<Edge> edges() {
        return smt;
    }

    public static void main(String[] args) {
        In in = new In("F:\\code\\java\\algorithms\\src\\algs4-data\\mediumEWG.txt");
        EdgeWeightGraph testGraph = new EdgeWeightGraph(in);
        KruskalSMT test = new KruskalSMT(testGraph);
        for (Edge e : test.edges()) {
            System.out.println(e);
        }
    }
}
