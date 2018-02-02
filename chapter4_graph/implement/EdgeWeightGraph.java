package chapter4_graph.implement;

import java.util.ArrayList;

public class EdgeWeightGraph {
    private final int v;
    private int e;
    private ArrayList<Edge>[] adj;

    public EdgeWeightGraph(int v) {
        this.v = v;
        this.e = 0;
        adj = (ArrayList<Edge>[])new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public int getV() {
        return v;
    }

    public int getE() {
        return e;
    }

    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        this.e++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        ArrayList<Edge> list = new ArrayList<>();
        for (int v = 0; v < this.v; ++v) {
            for (Edge e : adj[v]) {
                if (e.other(v) > v) {
                    list.add(e);
                }
            }
        }
        return list;
    }
}
