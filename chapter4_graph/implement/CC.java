package chapter4_graph.implement;

import java.util.ArrayList;

/**
 * 深度优先搜索查找联通分量
 *
 * @author RZD
 * @date 2017/12/5
 */

public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph g) {
        marked = new boolean[g.V()];
        id = new int[g.V()];
        for (int i = 0, V = g.V(); i < V; ++i) {
            if (!marked[i]) {
                dfs(g, i);
                ++count;
            }
        }
    }

    private void dfs(Graph g, int s) {
        marked[s] = true;
        id[s] = count;
        for (int x : g.getAdjAt(s)) {
            if (!marked[x]) {
                dfs(g, x);
            }
        }
    }

    private boolean connected(int x, int y) {
        return id[x] == id[y];
    }

    public int id(int x) {
        return id[x];
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        Graph testGraph = new Graph("F:\\code\\java\\algorithms\\algs4-data\\tinyG.txt");
        CC testCC = new CC(testGraph);
        int count = testCC.count();
        // 不能创建泛型数组
        ArrayList<Integer>[] components = (ArrayList<Integer>[]) new ArrayList[count];
        for (int i = 0; i < count; ++i) {
            components[i] = new ArrayList<>();
        }
        System.out.println(count + " components");
        for (int i = 0, v = testGraph.V(); i < v; ++i) {
            components[testCC.id(i)].add(i);
        }
        for (int i = 0; i < count; ++i) {
            for (int x : components[i]) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
