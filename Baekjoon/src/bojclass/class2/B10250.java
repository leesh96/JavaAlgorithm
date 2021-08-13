package bojclass.class2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 10250
 * 문제제목 : ACM 호텔
 * 난이도 : 브론즈 3
 * 제한사항 : 1초/256MB
 * 알고리즘 분류 : 구현
 *
 * 알고리즘 설명
 * 문제 조건에 맞게 인덱스를 행, 렬로 표현하는 방법
 *
 * 채점 결과 : 96ms/12268KB
 * 풀이 날짜 : 2021/07/17
**/

public class B10250 {
    static int t, h, w, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            int y, x;
            if (n % h == 0) {
                y = h;
                x = n / h;
            } else {
                y = n % h;
                x = n / h + 1;
            }
            bw.write(y + String.format("%02d", x) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
