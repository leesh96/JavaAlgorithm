package step.step2;

import java.io.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 14681
 * 문제제목 : 사분면 고르기
 * 난이도 : 브론즈 4
 * 제한사항 : 1초/512MB
 * 알고리즘 분류 : 수학, 구현, 기하학
 *
 * 알고리즘 설명
 * 사분면 판단 구현
 *
 * 채점 결과 : 144ms/14152KB
 * 풀이 날짜 : 2021/08/05
**/

public class B14681 {
    static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        x = Integer.parseInt(br.readLine());
        y = Integer.parseInt(br.readLine());
        if (x > 0 && y > 0) {
            bw.write("1");
        } else if (x < 0 && y > 0) {
            bw.write("2");
        } else if (x < 0 && y < 0) {
            bw.write("3");
        } else if (x > 0 && y < 0) {
            bw.write("4");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
