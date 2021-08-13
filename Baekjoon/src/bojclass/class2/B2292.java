package bojclass.class2;

import java.io.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 2292
 * 문제제목 : 벌집
 * 난이도 : 브론즈 3
 * 제한사항 : 2초/128MB
 * 알고리즘 분류 : 수학
 *
 * 알고리즘 설명
 * 규칙 찾기
 *
 * 채점 결과 : 84ms/11504KB
 * 풀이 날짜 : 2021/07/17
**/

public class B2292 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int idx = 1;
        int cur = 1;
        while (true) {
            if (cur >= n) {
                bw.write(idx + "\n");
                break;
            }
            cur += 6 * idx;
            idx++;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
