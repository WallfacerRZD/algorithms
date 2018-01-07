package chapter4_graph.implement;

import utils.In;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 已测试
 * 2018-1-7
 */
public class MyTopological {
    private Queue<Integer> order;

    public MyTopological(Digraph g, int[] degeres) {
        order = new LinkedList<>();
        Queue<Integer> vertexs = new LinkedList<>();
        for (int i = 0; i < g.v(); ++i) {
            if (degeres[i] == 0) {
                vertexs.offer(i);
            }
        }

        while (!vertexs.isEmpty()) {
            int x = vertexs.poll();
            order.offer(x);
            for (int w : g.getAdjAt(x)) {
                if (--degeres[w] == 0) {
                    vertexs.offer(w);
                }
            }
        }
    }

    public Iterable<Integer> getOrder() {
        return order;
    }

    public static void main(String[] args) {
        In in = new In("F:\\code\\java\\algorithms\\src\\chapter4_graph\\implement\\testGraph.txt");
        Digraph testGraph = new Digraph(13);
        while (in.hasNextLine()) {
            String line = in.getLine();
            String[] word = line.split(" ");
            for (int i = 1; i < word.length; ++i) {
                testGraph.addEdg(Integer.parseInt(word[0]), Integer.parseInt(word[i]));
            }
        }
        int[] degres = new int[13];
        Digraph reversedGraph = testGraph.reverse();
        for (int i = 0; i < reversedGraph.v(); i++) {
            degres[i] = reversedGraph.getAdjAt(i).size();
        }
        MyTopological test = new MyTopological(testGraph, degres);
        for (int x : test.getOrder()) {
            System.out.println(x);
        }
    }
}
