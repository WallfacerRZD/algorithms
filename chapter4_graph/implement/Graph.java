package chapter4_graph.implement;


import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private final int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Integer>[]) new LinkedList[V];
        // 初始化链表数组的每个元素
        for (int i = 0; i < adj.length; ++i) {
            adj[i] = new LinkedList();
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        ++E;
    }

    public Iterable<Integer> getAdjAt(int v){
        return adj[v];
    }
}
