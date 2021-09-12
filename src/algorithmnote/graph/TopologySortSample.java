package algorithmnote.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologySortSample {
    // 백준 1516번 게임 개발 문제
    static int n;
    static int[] inDegree, time, result;
    static Queue<Integer> queue;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        inDegree = new int[n+1];
        time = new int[n+1];
        graph = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= n; i++) {
            String[] inputs = br.readLine().split(" ");
            time[i] = Integer.parseInt(inputs[0]);
            for (int j = 1; !inputs[j].equals("-1"); j++) {
                inDegree[i]++;
                graph[Integer.parseInt(inputs[j])].add(i);
            }
        }

        result = new int[n+1];
        for (int i = 1; i <= n; i++) {
            result[i] = time[i];
        }

        queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int idx : graph[cur]) {
                result[idx] = Math.max(result[idx], result[cur] + time[idx]);
                inDegree[idx]--;
                if (inDegree[idx] == 0) {
                    queue.add(idx);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            bw.write(result[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
