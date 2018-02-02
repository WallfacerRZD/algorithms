package chapter4_graph.implement;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * 深度优先搜索实现拓扑排序
 * 深度优先的逆后序序列按dfs(x)结束时间递减排列
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph g) {
        marked = new boolean[g.v()];
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();
        for (int i = 0; i < g.v(); ++i) {
            if (!marked[i]) {
                dfs(g, i);
            }
        }
    }

    private void dfs(Digraph g, int v) {
        pre.offer(v);
        marked[v] = true;
        for (int w : g.getAdjAt(v)) {
            dfs(g, w);
        }
        post.offer(v);
        reversePost.push(v);
    }

    public Iterable<Integer> getPost() {
        return post;
    }

    public Iterable<Integer> getPre() {
        return pre;
    }

    public Stack<Integer> getReversePost() {
        return reversePost;
    }

}
