package baekjoon.simulation.bronze2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2605
문제제목 : 줄 세우기
난이도 : 브론즈 2
제한사항 : 1초/128MB
알고리즘 분류 : 구현

알고리즘 설명
1. ArrayList 사용
2. 삽입 인덱스 조작

채점 결과 : 144ms/14568KB
풀이 날짜 : 2021/11/27
*/

public class B2605 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int lastIdx = 0;
        for (int i = 1; i <= n; i++) {
            int position = Integer.parseInt(st.nextToken());
            if (i == 1) {
                list.add(i);
                lastIdx++;
                continue;
            }
            list.add(lastIdx - position, i);
            lastIdx++;
        }

        for (int s : list) {
            bw.write(s + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
