package chapter4_graph.implement;

import utils.In;

import java.util.ArrayList;

public class EdgeWeightedDigraph {
    private final int v;
    private int e;
    private ArrayList<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(In in) {
        this.v = Integer.parseInt(in.getLine());
        adj = (ArrayList<DirectedEdge>[]) new ArrayList[this.v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
        in.getLine();
        while (in.hasNextLine()) {
            String[] values = in.getLine().split(" ");
            int v = Integer.parseInt(values[0]);
            int w = Integer.parseInt(values[1]);
            double weight = Double.parseDouble(values[2]);
            DirectedEdge edge = new DirectedEdge(v, w, weight);
            addEdge(edge);
        }
    }

    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        ++this.e;
    }

    public int getV() {
        return v;
    }

    public int getE() {
        return e;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        ArrayList<DirectedEdge> edges = new ArrayList<>();
        for (int i = 0; i < getV(); ++i) {
            for (DirectedEdge e : adj[i]) {
                edges.add(e);
            }
        }
        return edges;
    }
}
