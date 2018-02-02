package chapter4_graph.implement;

import java.util.PriorityQueue;

/**
 * 未完成
 */
public class PrimMST {
    private Edge[] edgeTo;
    private double[] distTo;
    private boolean marked;

    public PrimMST(EdgeWeightGraph g) {
        edgeTo = new Edge[g.getV()];
        distTo = new double[g.getV()];
        for (int i = 0; i < g.getV(); ++i) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
    }
}
