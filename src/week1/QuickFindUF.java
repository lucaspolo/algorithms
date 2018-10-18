package week1;

public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int n) {
        id = new int[n];
        for(int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    // Constant time
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    /*
        Most expensive method O(n^2)
     */
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = qid;
        }
    }

    public static void main(String args[]) {
        QuickFindUF quf = new QuickFindUF(10);
        System.out.println(quf.connected(0,1));
        quf.union(5,9);
        System.out.println(quf.connected(5,9));
        quf.union(9,3);
        System.out.println(quf.connected(5,3));

        System.out.println(quf.connected(5,2));
    }
}
