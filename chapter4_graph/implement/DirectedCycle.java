package chapter4_graph.implement;

import java.util.Stack;

/**
 * not understand
 * data: 2017/12/26
 */

public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycle(Digraph g) {
        onStack = new boolean[g.v()];
        marked = new boolean[g.v()];
        edgeTo = new int[g.v()];
        for (int i = 0; i < g.v(); ++i) {
            if (!marked[i]) {
                dfs(g, i);
            }
        }
    }

    private void dfs(Digraph g, int s) {
        onStack[s] = true;
        marked[s] = true;
        for (int w : g.getAdjAt(s)) {
            if (this.hasCycle()) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = s;
                dfs(g, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int x = s; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(s);
            }
        }
        onStack[s] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
