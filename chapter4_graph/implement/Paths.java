package chapter4_graph.implement;

import java.util.Stack;

public class Paths {
    private boolean[] marked;
    // 以s为根节点的路径树
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

    public Paths(Graph g, int s) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;
        dfs(g, this.s);
    }

    public boolean hasPathTo(int x) {
        return marked[x];
    }

    public Stack<Integer> pathTo(int x) {
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
        int source = 1;
        Graph testGraph = new Graph("F:\\code\\java\\algorithms\\algs4-data\\tinyCG.txt");
        Paths testPaths = new Paths(testGraph, source);
        for (int i = 0, v = testGraph.V(); i < v; ++i) {
            if (testPaths.hasPathTo(i)) {
                Stack<Integer> paths = testPaths.pathTo(i);
                System.out.print(source + " to " + i + ":");
                while (!paths.empty()){
                    int x = paths.pop();
                    if (x != source)
                        System.out.print("-" + x);
                    else {
                        System.out.print(x);
                    }
                }
                System.out.println();
//                System.out.print(source + " to " + i + ": ");
//                for (int j = testPaths.pathTo(i).pop(); ) {
//                    if (j == source){
//                        System.out.print(j);
//                    }
//                    else {
//                        System.out.print("-" + j);
//                    }
//                }
//                System.out.println();
            }
        }
    }
}
