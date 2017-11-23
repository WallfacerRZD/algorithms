package chapter4_graph.implement;

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

    public static void main(String[] args){
        Graph test = new Graph("F:\\code\\java\\algorithms\\algs4-data\\tinyG.txt");
        DepthFirstSearch dfs = new DepthFirstSearch(test, 9);
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
