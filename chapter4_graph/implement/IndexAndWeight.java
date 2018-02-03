package chapter4_graph.implement;

public class IndexAndWeight {
    public int index;
    public double weight;

    public IndexAndWeight(int index, double weight) {
        this.index = index;
        this.weight = weight;
    }

    /**
     * PriorityQueue用equals方法比较对象
     */
    @Override
    public boolean equals(Object obj) {
        IndexAndWeight that = (IndexAndWeight)obj;
        return index == that.index && weight == that.weight;
    }
}
