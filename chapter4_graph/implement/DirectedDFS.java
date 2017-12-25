package chapter4_graph.implement;

import utils.In;

public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph graph, int s) {
        marked = new boolean[graph.v()];
        dfs(graph, s);
    }

    private void dfs(Digraph graph, int v) {
        marked[v] = true;
        for (int x : graph.getAdjAt(v)) {
            if (!marked[x]) {
                dfs(graph, x);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public static void main(String[] args) {
        String path = "F:\\code\\java\\algorithms\\algs4-data\\tinyDG.txt";
        In in = new In(path);
        Digraph testGraph = new Digraph(in);
        int source = 2;
        DirectedDFS test = new DirectedDFS(testGraph, source);
        for (int i = 0, v = testGraph.v(); i < v; ++i) {
            if (test.marked(i)){
                System.out.println(" " + i);
            }
        }

    }
}
