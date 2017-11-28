package chapter4_graph.implement;

import java.util.Stack;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph g, int s) {
        marked = new boolean[g.V()];
//        for (int i = 0; i < marked.length; ++i) {
//            marked[i] = false;
//        }
        dfs(g, s);
    }

//    private void dfs(Graph g, int v) {
//        marked[v] = true;
//        ++count;
//        for(int x : g.getAdjAt(v)){
//            if(!marked[x]){
//                dfs(g, x);
//            }
//        }
//    }

    // no recursive
    private void dfs(Graph g, int v) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(v);
        while(!stack.empty()) {
            int x = stack.pop();
            if (!marked[x]) {
                ++count;
                marked[x] = true;
            }
            for (int i : g.getAdjAt(x)){
                if (!marked[i]){
                    stack.push(i);
                }
//                stack.push(i);
            }
            System.out.println(stack.size());
        }
    }



    public boolean marked(int x){
        return marked[x];
    }
    public int count(){
        return count;
    }

    public static void main(String[] args){
        Graph test = new Graph("F:\\code\\java\\algorithms\\algs4-data\\tinyCG.txt");
//        Graph test = new Graph(6, 5);
        DepthFirstSearch dfs = new DepthFirstSearch(test, 0);
        for (int i = 0; i < test.V(); ++i){
            if (dfs.marked(i)){
                System.out.print(i + " ");
            }
        }
        if (dfs.count() == test.V()){
            System.out.println("connected!!");
        }
        else{
            System.out.println("not!!");
        }
    }
}
