package chapter4_graph.implement;


import utils.In;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SymbolGraph {
    /**
     * name到编号的映射
     */
    private Map<String, Integer> st;
    /**
     * 编号到name的反向映射
     */
    private String[] keys;
    private Graph g;

    public SymbolGraph(String path, String separation) {
        In in = new In(path);
        st = new HashMap<>();
        while (in.hasNextLine()) {
            String line = in.getLine();
            String[] words = line.split(separation);
            for (String word : words) {
                if (!st.containsKey(word)) {
                    st.put(word, st.size());
                }
            }
        }

        keys = new String[st.size()];
        for (String key : st.keySet()) {
            keys[st.get(key)] = key;
        }

        // 构造图
        g = new Graph(st.size());
        in = new In(path);
        while (in.hasNextLine()) {
            String line = in.getLine();
            String[] words = line.split(separation);
            for (int i = 1; i < words.length; ++i) {
                g.addEdge(st.get(words[1]), st.get(words[i]));
            }
        }


    }

    public boolean contains(String key) {
        return st.containsKey(key);
    }

    public int index(String key) {
        return st.get(key);
    }

    public String name(int x) {
        return keys[x];
    }

    public Graph getG() {
        return g;
    }

    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph("F:\\code\\java\\algorithms\\algs4-data\\movies.txt", "/");

    }
}
