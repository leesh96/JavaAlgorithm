package baekjoon.simulation.silver5;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2422
문제제목 : 한윤정이 이탈리아에 가서 아이스크림을 사먹는데
난이도 : 실버 5
제한사항 : 1초/128MB
알고리즘 분류 : 브루트포스 알고리즘

알고리즘 설명
1. 가능한 조합을 다 만들고
2. 불가능한 조합인지 체크해주기
3. 체크는 연결 그래프 형태로 구현

채점 결과 : 292ms/19732KB
풀이 날짜 : 2022/01/03
*/

public class B2422 {
    static int n, m;
    static int count;
    static boolean[][] notComb;
    static boolean[] visit;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        notComb = new boolean[n+1][n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            notComb[a][b] = true;
            notComb[b][a] = true;
        }

        visit = new boolean[n+1];
        count = 0;
        nums = new int[3];
        comb(1, 0);

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void comb(int idx, int depth) {
        if (depth == 3) {
            if (!checkNotComb()) {
                count++;
            }
            return;
        }

        for (int i = idx; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                nums[depth] = i;
                comb(i, depth + 1);
                visit[i] = false;
            }
        }
    }

    static boolean checkNotComb() {
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (notComb[nums[i]][nums[j]]) {
                    return true;
                }
            }
        }
        return false;
    }
}
