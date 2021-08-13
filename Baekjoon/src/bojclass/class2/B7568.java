package bojclass.class2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 7568
 * 문제제목 : 덩치
 * 난이도 : 실버 5
 * 제한사항 : 1초/128MB
 * 알고리즘 분류 : 구현, 완전 탐색
 *
 * 알고리즘 설명
 * 배열 완전 탐색 비교
 *
 * 채점 결과 : 11668KB/80ms
 * 풀이 날짜 : 2021/07/22
**/

public class B7568 {
    static int n;
    static body[] arr;
    static int[] score;

    static class body {
        int height, weight;

        public body(int w, int h) {
            this.height = h;
            this.weight = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new body[n];
        score = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new body(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (arr[i].height < arr[j].height && arr[i].weight < arr[j].weight) {
                    count++;
                }
            }
            score[i] = count + 1;
        }

        for (int s : score) {
            bw.write(s + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
