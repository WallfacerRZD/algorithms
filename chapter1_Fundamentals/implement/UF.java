package chapter1_Fundamentals.implement;

import java.util.Scanner;

public class UF {
    private int[] id;
    private int count;

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; ++i) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // quick find
//    private int find(int x) {
//        return id[x];
//    }
//
//    public void union(int p, int q) {
//        int pID = find(p);
//        int qID = find(q);
//        if (pID != qID) {
//            for (int i = 0, N = id.length; i < N; ++i) {
//                if (id[i] == qID) {
//                    id[i] = pID;
//                }
//            }
//            --count;
//        }
//    }

    // quick union

    private int find(int x){
//        while (x != id[x]){
//            x = id[x];
//        }
//        return x;
        if(id[x] == x){
            return x;
        }
        return find(id[x]);
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot){
            id[qRoot] = pRoot;
            --count;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        UF test = new UF(N);
        for(int i = 0 ; i < 5; ++i){
            int q = input.nextInt();
            int p = input.nextInt();
            test.union(q, p);
        }
        System.out.println(test.count());
    }
}