package baekjoon.simulation.silver5;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

/*
플랫폼 : 백준
문제번호 : 11068
문제제목 : 회문인 수
난이도 : 실버 5
제한사항 : 1초/256MB
알고리즘 분류 : 수학, 브루트포스 알고리즘

알고리즘 설명
1. 2 ~ 64진법 변환 각 자릿 수를 덱에 넣고
2. 앞뒤로 하나씩 빼면서 같은지 검사
3. 한번이라도 회문이 나오면 종료

채점 결과 : 136ms/15204KB
풀이 날짜 : 2022/01/10
*/

public class B11068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            boolean flag = false;

            for (int i = 2; i <= 64; i++) {
                int temp = n;
                Deque<Integer> dq = new LinkedList<>();

                while (temp > 0) {
                    dq.addLast(temp % i);
                    temp /= i;
                }

                boolean isReverseSame = true;
                while (dq.size() >= 2) {
                    if (dq.pollFirst() != dq.pollLast()) {
                        isReverseSame = false;
                        break;
                    }
                }

                if (isReverseSame) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
