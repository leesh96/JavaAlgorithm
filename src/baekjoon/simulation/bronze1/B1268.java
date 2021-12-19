package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1268
문제제목 : 임시 반장 정하기
난이도 : 브론즈 1
제한사항 : 2초/128MB
알고리즘 분류 : 구현

알고리즘 설명
1. 학생들의 각 학년의 반을 저장해놓고
2. 각 학생들마다 같은 반이 된 적이 있는 친구를 담는 집합을 두고
3. 같은 반이었던 적이 있다면 집합에 넣는다.
4. 집합 크기가 제일 큰 학생이 회장

채점 결과 : 372ms/133088KB
풀이 날짜 : 2021/12/19
*/

public class B1268 {
    static int n;
    static int[][] classNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        classNum = new int[n][5];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                classNum[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int k = 0; k < n; k++) {
            Set<Integer> friends = new HashSet<>();
            for (int j = 0; j < 5; j++) {
                int cur = classNum[k][j];

                for (int i = 0; i < n; i++) {
                    if (i == k) continue;
                    if (classNum[i][j] == cur) {
                        friends.add(i);
                    }
                }
            }

            if (friends.size() > max) {
                idx = k;
                max = friends.size();
            }
        }

        bw.write(String.format("%d", idx+1));
        bw.flush();
        bw.close();
        br.close();
    }
}
