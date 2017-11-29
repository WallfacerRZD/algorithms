package chapter4_graph.implement;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class BreadFirstPaths {
    private boolean marked[];
    private int edgeTo[];
    private final int source;

    public BreadFirstPaths(Graph g, int s) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        source = s;
        bfs(g, source);
    }

    private void bfs(Graph g, int s) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            marked[v] = true;
            for (int x : g.getAdjAt(v)) {
                if (!marked[x]) {
                    edgeTo[x] = v;
                    queue.offer(x);
                }
            }
        }
    }

    public boolean hasPathTo(int x) {
        return marked[x];
    }

    public Iterable<Integer> pathTo(int x) {
        if (!hasPathTo(x)) {
            return null;
        } else {
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = x; i != source; i = edgeTo[i]) {
                stack.push(i);
            }
            stack.push(source);
            return stack;
        }
    }

    public static void main(String[] args) {
        int source = 0;
        Graph testGraph = new Graph("F:\\code\\java\\algorithms\\algs4-data\\tinyCG.txt");
        BreadFirstPaths testSearch = new BreadFirstPaths(testGraph, source);
        for (int i = 0, v = testGraph.V(); i < v; ++i){
            if (testSearch.hasPathTo(i)){
                System.out.print(source + " to " + i + ": ");
                Stack<Integer> stack = (Stack<Integer>) testSearch.pathTo(i);
                while (!stack.empty()){
                    int x = stack.pop();
                    if (x == source){
                        System.out.print(x);
                    }else{
                        System.out.print("->" + x);
                    }
                }
                System.out.println();
            }
        }
    }

}
