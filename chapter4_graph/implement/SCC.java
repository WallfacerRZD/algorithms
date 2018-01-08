package chapter4_graph.implement;

import java.util.Stack;

/**
 * kosaraju算法查找强连通分量
 * 算法实现: 对原图的转置图进行dfs并记录逆后序序列(伪拓扑排序)
 * 然后按得到的序列顺序对原图进行dfs
 *
 * 算法的正确性依赖于以下事实:
 * 0. 强连通是等价关系, 可划分等价类(强连通分量)
 * 1. 原图与转置图的强连通完全分量相同(转置不影响强连通分量的划分)
 * 2. 强连通分量的分量图是有向无环图(如果任意两个分量有环,则这两个分量相互可达,故可以看作同一分量)
 * 3. 转置图逆后序序列中节点完成的时间依次递减(故整体上看:搜索整个分量的时间依次递减)
 * 4. 在转置图的分量图中连通分量只能从完成时间较长的分量指向完成时间较短的分量(在原图中则相反)
 * 5. 故在原图中dfs逆后序序列第一个节点(其所在的分量不指向任何其他分量)不会访问到其他分量
 * 6. dfs任何一个节点即可标记其所在的强连通分量
 * 7. 逆后序序列中后一个分量只能指向前面的分量(dfs时会检测到前面的分量已经访问, 故也不会访问到其他分量)
 */
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
