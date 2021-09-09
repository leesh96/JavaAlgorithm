package kakaotest.blind2021;

public class KB4 {
    public static void main(String[] args) {
        System.out.println(solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
    }

    static int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] graph = new int[n+1][n+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = 1000000000;
                }
            }
        }

        for (int i = 0; i < fares.length; i++) {
            int c = fares[i][0];
            int d = fares[i][1];
            int f = fares[i][2];
            graph[c][d] = f;
            graph[d][c] = f;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (i == k) {
                    continue;
                }
                for (int j = 1; j <= n; j++) {
                    if (i == j || j == k) {
                        continue;
                    }
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int answer = 1000000000;
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, graph[s][i] + graph[i][a] + graph[i][b]);
        }

        return answer;
    }
}
