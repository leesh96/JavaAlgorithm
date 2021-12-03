package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1357
문제제목 : 뒤집힌 덧셈
난이도 : 브론즈 1
제한사항 : 2초/128MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 큐를 활용하여 숫자 뒤집기

채점 결과 : 124ms/14324KB
풀이 날짜 : 2021/12/03
*/

public class B1357 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        bw.write(rev((rev(x) + rev(y))) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static int rev(int x) {
        Queue<Integer> nums = new LinkedList<>();

        while (x > 0) {
            nums.offer(x % 10);
            x /= 10;
        }

        int res = 0;
        while (!nums.isEmpty()) {
            res = res * 10 + nums.poll();
        }

        return res;
    }
}
