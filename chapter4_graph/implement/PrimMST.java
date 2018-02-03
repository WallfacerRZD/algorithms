package chapter4_graph.implement;

import utils.In;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 及时Prim算法, 寻找最小生成树
 * 空间复杂度O(E), 时间复杂度O(ElogE)
 *
 * 思路:
 *      edgeTo[v]: v点到最小生成树的最佳边
 *      distTo[v]: v点到最小生成树的距离
 *      初始化distTo数组为无穷的, distTo[s]为0, 将源点s加入索引优先队列
 *      每次从索引优先队列中取出一个点(离最小生成树最近), 遍历此点邻接的边
 *      更新两个数组数据, 具体看visit(v)的实现
 *
 * @date 2018/2/3
 */
public class PrimMST {
    private Edge[] edgeTo;
    private double[] distTo;
    private boolean marked;
    IndexPQ pq;

    public PrimMST(EdgeWeightGraph g) {
        edgeTo = new Edge[g.getV()];
        distTo = new double[g.getV()];
        pq = new IndexPQ();
        for (int i = 0; i < g.getV(); ++i) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        pq.insert(new IndexAndWeight(0, 0.0));
        while(!pq.isEmpty()) {
            visit(g, pq.poll());
        }
    }

    private void visit(EdgeWeightGraph g, IndexAndWeight x) {
        int v = x.index;
        for (Edge e : g.adj(v)) {
            int w = e.other(v);
            if (distTo[w] > e.weight()) {
                double oldDist = distTo[w];
                distTo[w] = e.weight();
                edgeTo[w] = e;
                if (pq.contains(new IndexAndWeight(w, oldDist))) {
                    pq.change(new IndexAndWeight(w, oldDist), distTo[w]);
                }
                else {
                    pq.insert(new IndexAndWeight(w, distTo[w]));
                }
            }
        }
    }

    public Iterable<Edge> edges() {
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 1; i < edgeTo.length; ++i) {
            edges.add(edgeTo[i]);
        }
        return edges;
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
