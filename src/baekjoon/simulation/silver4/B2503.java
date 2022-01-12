package baekjoon.simulation.silver4;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2503
문제제목 : 숫자 야구
난이도 : 실버 4
제한사항 : 1초/128MB
알고리즘 분류 : 브루트포스 알고리즘

알고리즘 설명
1. 가능한 숫자를 순열로 만들고
2. 순열이 완성될 때마다 스트라이크, 볼 체크해서
3. 정답 가능한 경우인지 체크해서 카운트

채점 결과 : 132ms/14284KB
풀이 날짜 : 2022/01/12
*/

public class B2503 {
    static int n;
    static String[] input;
    static int[] strike;
    static int[] ball;

    static int[] nums;
    static boolean[] visit;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        input = new String[n];
        strike = new int[n];
        ball = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            input[i] = st.nextToken();
            strike[i] = Integer.parseInt(st.nextToken());
            ball[i] = Integer.parseInt(st.nextToken());
        }

        nums = new int[3];
        visit = new boolean[10];
        makePerm(0);

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void makePerm(int depth) {
        if (depth == 3) {
            if (check()) count++;
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!visit[i]) {
                visit[i] = true;
                nums[depth] = i;
                makePerm(depth + 1);
                visit[i] = false;
            }
        }
    }

    static boolean check() {
        for (int i = 0; i < n; i++) {
            int s = 0;
            int b = 0;

            for (int j = 0; j < 3; j++) {
                int cur = input[i].charAt(j) - '0';
                if (cur == nums[j]) s++;
            }

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j == k) continue;
                    int cur = input[i].charAt(j) - '0';
                    if (cur == nums[k]) b++;
                }
            }

            if (strike[i] != s || ball[i] != b) {
                return false;
            }
        }

        return true;
    }
}
