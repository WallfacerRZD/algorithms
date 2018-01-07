package chapter4_graph.implement;


import utils.In;

import java.util.ArrayList;

public class Digraph {
    private final int v;
    private int e;
    private ArrayList<Integer>[] adj;

    public Digraph(int v) {
        this.v = v;
        e = 0;
        adj = (ArrayList<Integer>[]) new ArrayList[this.v];
        for (int i = 0; i < this.v; ++i) {
            adj[i] = new ArrayList<>();
        }
    }

    public Digraph(In in) {
        this.v = Integer.parseInt(in.getLine());
        e = 0;
        adj = (ArrayList<Integer>[]) new ArrayList[this.v];
        for (int i = 0; i < this.v; ++i) {
            adj[i] = new ArrayList<>();
        }
        // 去掉E
        String line = in.getLine();
        while (in.hasNextLine()) {
            line = in.getLine();
            String[] datas = line.split("\\s+");
            int v = Integer.parseInt(datas[1]);
            int w = Integer.parseInt(datas[2]);
            addEdg(v, w);
        }

    }

    public int v() {
        return this.v;
    }

    public int e() {
        return this.e;
    }

    public void addEdg(int v, int w) {
        adj[v].add(w);
        ++e;
    }

    public ArrayList<Integer> getAdjAt(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph temp = new Digraph(this.v);
        for (int i = 0; i < this.v; ++i) {
            for (int w : getAdjAt(i)) {
                temp.addEdg(w, i);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        String path = "F:\\code\\java\\algorithms\\algs4-data\\tinyDG.txt";
        Digraph test = new Digraph(new In(path));
        System.out.println(test.e());
    }

}
