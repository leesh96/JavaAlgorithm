package baekjoon.simulation.silver5;

import java.io.*;
import java.util.ArrayList;

/*
플랫폼 : 백준
문제번호 : 2635
문제제목 : 수 이어가기
난이도 : 실버 5
제한사항 : 1초/128MB
알고리즘 분류 : 수학, 브루트포스 알고리즘

알고리즘 설명
1. 주어진 수의 절반까지 내림차순으로 탐색 -> 절반보다 크게 하면 결과가 계속 3
2. 수열을 규칙대로 만들어주고
3. 가장 긴 길이로 갱신

채점 결과 : 160ms/17440KB
풀이 날짜 : 2022/01/07
*/

public class B2635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> answer = new ArrayList<>();
        int length = 0;
        for (int i = n; i >= n / 2; i--) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(n);

            int prev2 = n;
            int prev1 = i;

            while (true) {
                if (prev1 < 0) break;

                int cur = prev2;
                if (prev1 >= 0) {
                    temp.add(prev1);
                }

                prev2 = prev1;
                prev1 = cur - prev2;
            }

            if (length < temp.size()) {
                length = temp.size();
                answer = temp;
            }
        }

        bw.write(length + "\n");
        for (int i : answer) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
