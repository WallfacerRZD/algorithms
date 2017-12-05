package chapter4_graph.implement;

import java.util.Stack;

public class DepthFirstPaths {
    private boolean[] marked;
    //    以s为根节点的路径树
    private int[] edgeTo;
    private final int s;

    private void dfs(Graph g, int s) {
        marked[s] = true;
        for (int x : g.getAdjAt(s)) {
            if (!marked[x]) {
                edgeTo[x] = s;
                dfs(g, x);
            }
        }
    }

    public DepthFirstPaths(Graph g, int s) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;
        dfs(g, this.s);
    }

    public boolean hasPathTo(int x) {
        return marked[x];
    }

    public Iterable<Integer> pathTo(int x) {
        if (!hasPathTo(x)) {
            return null;
        } else {
            Stack<Integer> paths = new Stack<>();
            for (int i = x; i != this.s; i = edgeTo[i]) {
                paths.push(i);
            }
            paths.push(s);
            return paths;
        }
    }

    public static void main(String[] args) {
        int source = 0;
        Graph testGraph = new Graph("F:\\code\\java\\algorithms\\algs4-data\\tinyCG.txt");
        DepthFirstPaths testDepthFirstPaths = new DepthFirstPaths(testGraph, source);
        for (int i = 0, v = testGraph.V(); i < v; ++i) {
            if (testDepthFirstPaths.hasPathTo(i)) {
                Stack<Integer> paths = (Stack<Integer>) testDepthFirstPaths.pathTo(i);
                System.out.print(source + " to " + i + ":");
                while (!paths.empty()) {
                    int x = paths.pop();
                    if (x != source) {
                        System.out.print("-" + x);
                    } else {
                        System.out.print(x);
                    }
                }
                System.out.println();


//                System.out.print(source + " to " + i + ": ");
//                for (int x : testDepthFirstPaths.pathTo(i)) {
//                    if (x == source){
//                        System.out.print(x);
//                    }
//                    else {
//                        System.out.print("->" + x);
//                    }
//                }
//                System.out.println();
            }
        }
    }
}
