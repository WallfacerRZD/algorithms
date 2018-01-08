package chapter4_graph.implement;

import java.util.Stack;

public class SCC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public SCC(Digraph g) {
        marked = new boolean[g.v()];
        id = new int[g.v()];
        count = 0;
        // 原图的转置图
        Digraph GT = g.reverse();
        DepthFirstOrder order = new DepthFirstOrder(GT);
        Stack<Integer> reversedPost = order.getReversePost();
        while(!reversedPost.isEmpty()) {
            int v = reversedPost.pop();
            if (!marked[v]) {
                dfs(g, v);
                count++;
            }
        }
    }

    private void dfs(Digraph g, int s) {
        marked[s] = true;
        id[s] = count;
        for (int w : g.getAdjAt(s)) {
            dfs(g, w);
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }
    public static void main(String[] args) {

    }



}
