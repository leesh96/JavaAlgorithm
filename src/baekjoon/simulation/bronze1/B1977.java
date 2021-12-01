package baekjoon.simulation.bronze1;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 1977
문제제목 : 완전제곱수
난이도 : 브론즈 1
제한사항 : 2초/128MB
알고리즘 분류 : 수학, 구현

알고리즘 설명
1. 천장함수, 바닥함수 활용해서 범위 구하기
2. 제곱수 합, 최소 값 찾기

채점 결과 : 132ms/14392KB
풀이 날짜 : 2021/12/01
*/

public class B1977 {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        m = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        boolean flag = false;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = (int) Math.ceil(Math.sqrt(m)); i <= (int)Math.floor(Math.sqrt(n)); i++) {
            flag = true;
            int temp = (int) Math.pow(i, 2);
            sum += temp;
            min = Math.min(min, temp);
        }

        if (!flag) {
            bw.write("-1");
        } else {
            bw.write(String.format("%d\n%d", sum, min));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
