package week1;

public class QuickUnionImprovedUF {
    private int[] id;
    private int[] sz;

    public QuickUnionImprovedUF(int n) {
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int i) {
        if (i == id[i]) return i;
        else return root(id[id[i]]); // Ajuda a achatar a árvore
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
        if (rootP == rootQ) return;
        // Irá atribuir a raiz da menor arvore, balanceando
        if (sz[rootP] < sz[rootQ]) {
            id[rootP] = rootQ;
            sz[rootQ] += sz[rootP];
        } else {
            id[rootQ] = rootP;
            sz[rootP] += sz[rootQ];
        }
    }

    public static void main(String[] args) {
        QuickUnionImprovedUF qu = new QuickUnionImprovedUF(10);
        System.out.println(qu.root(5));
        qu.union(5,4);
        System.out.println(qu.root(5));
        System.out.println(qu.connected(4,5));
        qu.union(5, 9);
        System.out.println(qu.root(9));
        System.out.println(qu.connected(4,9));
        System.out.println(qu.connected(4,3));
    }
}
