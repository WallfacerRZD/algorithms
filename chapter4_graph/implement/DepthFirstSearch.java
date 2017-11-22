package chapter4_graph.implement;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph g, int s) {
        marked = new boolean[g.V()];
        for (int i = 0; i < marked.length; ++i) {
            marked[i] = false;
        }
        dfs(g, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        ++count;
        for(int x : g.getAdjAt(v)){
            if(!marked[x]){
                dfs(g, x);
            }
        }
    }
    public boolean marked(int x){
        return marked[x];
    }
    public int count(){
        return count;
    }
}
