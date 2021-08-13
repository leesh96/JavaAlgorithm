package bojclass.class2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 4153
 * 문제제목 : 직각삼각형
 * 난이도 : 브론즈 3
 * 제한사항 : 1초/128MB
 * 알고리즘 분류 : 수학, 기하학
 *
 * 알고리즘 설명
 * 피타고라스의 정의 구현
 *
 * 채점 결과 : 76ms/11376KB
 * 풀이 날짜 : 2021/07/17
**/

public class B4153 {
    static int a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            int max = Math.max(c, Math.max(a, b));
            if (max == c) {
                if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
                    bw.write("right\n");
                } else {
                    bw.write("wrong\n");
                }
            } else if (max == a) {
                if (Math.pow(c, 2) + Math.pow(b, 2) == Math.pow(a, 2)) {
                    bw.write("right\n");
                } else {
                    bw.write("wrong\n");
                }
            } else {
                if (Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2)) {
                    bw.write("right\n");
                } else {
                    bw.write("wrong\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
