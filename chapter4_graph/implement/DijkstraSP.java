package chapter4_graph.implement;

import utils.In;

import java.util.Stack;

/**
 * Dijkstra算法, 计算最短路径
 * 空间复杂度O(V), 时间复杂度O(ElogV)
 *
 * 思路:
 *      edgeTo[v]: 源点s到v点的最短路径上的最后一条边.
 *      distTo[v]: 源点s到v点的最短距离
 *      relax(v): 松弛v点邻接的每条边.
 *      初始化distTo数组为无穷大, distTo[s]为0, 将源点加入到索引优先队列
 *      每次从优先队列取出一点(离源点最近), 松弛该点邻接的每条边
 *      
 * @date 2018/2/3
 */
public class DijkstraSP {
    private int s;
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private IndexPQ pq;

    public DijkstraSP(EdgeWeightedDigraph g, int s) {
        this.s = s;
        distTo = new double[g.getV()];
        edgeTo = new DirectedEdge[g.getV()];
        pq = new IndexPQ();

        for (int v = 0; v < g.getV(); ++v) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0;

        pq.insert(new IndexAndWeight(s, 0.0));

        while (!pq.isEmpty()) {
            relax(g, pq.poll());
        }
    }

    private void relax(EdgeWeightedDigraph g, IndexAndWeight x) {
        int v = x.index;
        for (DirectedEdge e : g.adj(v)) {
            int w = e.to();
            if (distTo(w) > distTo[v] + e.getWeight()) {
                double oldDist = distTo[w];
                distTo[w] = distTo[v] + e.getWeight();
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
    double distTo(int v) {
        return distTo[v];
    }

    boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Stack<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }

    public static void main(String[] args) {
        In in = new In("F:\\code\\java\\algorithms\\src\\algs4-data\\mediumEWD.txt");
        EdgeWeightedDigraph testGraph = new EdgeWeightedDigraph(in);
        int source = 0;
        DijkstraSP test = new DijkstraSP(testGraph, source);

        for (int v = 0; v < testGraph.getV(); ++v) {
            if (test.hasPathTo(v)) {
                System.out.print(String.format("%d->%d (%.2f): ", source, v, test.distTo(v)));
                Stack<DirectedEdge> path = test.pathTo(v);
                while (!path.isEmpty()) {
                    System.out.print(path.pop() + " ");
                }
                System.out.println();
            }
        }
    }
}
