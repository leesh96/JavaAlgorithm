package baekjoon.simulation.silver5;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1969
문제제목 : DNA
난이도 : 실버 5
제한사항 : 2초/128MB
알고리즘 분류 : 구현, 문자열, 브루트포스 알고리즘

알고리즘 설명
1. 각 자릿수를 비교하면서 가장 많이 나온 유전자 문자와 개수 저장
2. 가장 많이 등장한 유전자가 최소 해밍 거리임

채점 결과 : 144ms/15608KB
풀이 날짜 : 2022/01/02
*/

public class B1969 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] dna = new String[n];
        for (int i = 0; i < n; i++) {
            dna[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        int dist = 0;
        for (int k = 0; k < m; k++) {
            int[] count = new int[4];
            for (int i = 0; i < n; i++) {
                char cur = dna[i].charAt(k);

                if (cur == 'A') {
                    count[0]++;
                } else if (cur == 'C') {
                    count[1]++;
                } else if (cur == 'G') {
                    count[2]++;
                } else {
                    count[3]++;
                }
            }

            int idx = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 4; i++) {
                if (count[i] > max) {
                    idx = i;
                    max = count[i];
                }
            }

            dist += (n - max);
            if (idx == 0) {
                sb.append('A');
            } else if (idx == 1) {
                sb.append('C');
            } else if (idx == 2) {
                sb.append('G');
            } else {
                sb.append('T');
            }
        }

        bw.write(String.format("%s\n%d", sb, dist));
        bw.flush();
        bw.close();
        br.close();
    }
}
