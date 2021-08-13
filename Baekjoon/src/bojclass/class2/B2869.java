package bojclass.class2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 2869
 * 문제제목 : 달팽이는 올라가고 싶다
 * 난이도 : 브론즈 1
 * 제한사항 : 0.15초/128MB
 * 알고리즘 분류 : 수학
 *
 * 알고리즘 설명
 * 규칙 찾아서 수식 세우기
 *
 * 채점 결과 : 76ms/11512KB
 * 풀이 날짜 : 2021/07/17
**/

public class B2869 {
    static int a, b, v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        int gap = a - b;
        if ((v - a) % gap == 0) {
            bw.write(((v - a) / gap + 1) + "\n");
        } else {
            bw.write(((v - a) / gap + 2) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
