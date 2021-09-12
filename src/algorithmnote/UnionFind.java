package algorithmnote;

public class UnionFind {
    // 유니온-파인드
    static int[] parent;

    public static void main(String[] args) {
        // 아래처럼 초기화 필요
        int n = 10;
        parent = new int[11];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}
