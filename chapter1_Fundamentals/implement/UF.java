package chapter1_Fundamentals.implement;

import java.util.Scanner;

public class UF {
    private int[] id;
    private int[] size;
    private int count;

    // weighted
/*    public UF(int N) {
        count = N;
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; ++i) {
            id[i] = i;
            size[i] = 1;
        }
    }*/

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; ++i) {
            id[i] = i;
        }
    }

    private int find(int x) {
/*       while (x != id[x]){
           x = id[x];
       }
       return x;*/

       return id[x] == x ? x : find(id[x]);
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) {
            id[pRoot] = qRoot;
        }
        --count;
    }

    // quick find
/*   private int find(int x) {
       return id[x];
   }

   public void union(int p, int q) {
       int pID = find(p);
       int qID = find(q);
       if (pID != qID) {
           for (int i = 0, N = id.length; i < N; ++i) {
               if (id[i] == qID) {
                   id[i] = pID;
               }
           }
           --count;
       }
   }*/

    // quick union


/*    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) {
            if (size[pRoot] > size[qRoot]) {
                id[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            } else {
                id[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            }
            --count;
        }
    }*/

}
