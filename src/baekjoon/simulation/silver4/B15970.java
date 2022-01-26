package baekjoon.simulation.silver4;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 15970
문제제목 : 화살표 그리기
난이도 : 실버 4
제한사항 : 2초/512MB
알고리즘 분류 : 브루트포스 알고리즘, 정렬

알고리즘 설명
1. 각 색깔 별로 등장하는 좌표를 우선순위 큐에 넣음 -> 처음 좌표부터 화살표의 길이를 알 수 있음
2. 각 색깔 우선순위 큐에 대해 이전 점, 현재 점, 다음 점에 대해서 화살표 길이 판단해서 길이 더해줌

채점 결과 : 204ms/16580KB
풀이 날짜 : 2022/01/26
*/

public class B15970 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer>[] map = new PriorityQueue[n+1];
        for (int i = 1; i <= n; i++) {
            map[i] = new PriorityQueue();
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int point = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());

            map[color].offer(point);
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (!map[i].isEmpty()) {
                int prev = -1;
                while (!map[i].isEmpty()) {
                    int cur = map[i].poll();

                    if (map[i].isEmpty()) {
                        if (prev != -1) answer += cur - prev;
                        break;
                    } else {
                        int next = map[i].peek();
                        if (prev != -1) answer += Math.min(cur - prev, next - cur);
                        else answer += next - cur;
                        prev = cur;
                    }
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
