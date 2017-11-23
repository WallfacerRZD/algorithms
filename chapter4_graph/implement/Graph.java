package chapter4_graph.implement;


import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Integer>[]) new LinkedList[V];
        // 初始化链表数组的每个元素
        for (int i = 0; i < adj.length; ++i) {
            adj[i] = new LinkedList();
        }
    }

    public Graph(String path) {
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            this.V = Integer.parseInt(br.readLine());
            int E = Integer.parseInt(br.readLine());
            adj = (LinkedList<Integer>[]) new LinkedList[V];
            // 初始化链表数组的每个元素
            for (int i = 0; i < adj.length; ++i) {
                adj[i] = new LinkedList();
            }

            for (int i = 0; i < E; ++i){
                String[] data = br.readLine().split(" ");
                int data1 = Integer.parseInt(data[0]);
                int data2 = Integer.parseInt(data[1]);
                addEdge(data1, data2);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        ++E;
    }

    public Iterable<Integer> getAdjAt(int v) {
        return adj[v];
    }

        // 读取文本文件
//    public static void main(String[] args) {
//        String path = "F:\\code\\java\\algorithms\\algs4-data\\tinyG.txt";
//        try {
//            FileReader fr = new FileReader(path);
//            BufferedReader br = new BufferedReader(fr);
//            String str = "";
//            String line;
//            while ((line = br.readLine()) != null) {
//                str += line;
//            }
//            System.out.println(str);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
