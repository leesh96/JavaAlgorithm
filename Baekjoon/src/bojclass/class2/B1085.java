package bojclass.class2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1085
 * 문제제목 : 직사각형에서 탈출
 * 난이도 : 브론즈 3
 * 제한사항 : 2초/128MB
 * 알고리즘 분류 : 수학, 기하학
 *
 * 알고리즘 설명
 * 점과 점 사이의 거리 공식 활용
 *
 * 채점 결과 : 80ms/11596KB
 * 풀이 날짜 : 2021/07/17
**/

public class B1085 {
    static int x, y, w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int col = Math.min(x, w - x);
        int row = Math.min(y, h - y);
        int min = (int) Math.sqrt(Math.pow(w - x, 2) + Math.pow(h - y, 2));
        min = Math.min(min, Math.min(col, row));
        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
