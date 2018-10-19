package week1;

public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) id[i] = i;
    }

    private int root(int i) {
        if (i == id[i]) return i;
        else return root(id[i]);
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    /*
        Most expensive method
     */
    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        id[rootP] = rootQ;
    }

    public static void main(String[] args) {
        QuickUnionUF qu = new QuickUnionUF(10);
        System.out.println(qu.root(5));
        qu.union(5,4);
        System.out.println(qu.root(5));
        System.out.println(qu.connected(4,5));
        qu.union(5, 9);
        System.out.println(qu.root(9));
        System.out.println(qu.connected(4,9));
    }
}
