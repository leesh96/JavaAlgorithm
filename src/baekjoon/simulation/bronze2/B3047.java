package baekjoon.simulation.bronze2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 3047
문제제목 : ABC
난이도 : 브론즈 2
제한사항 : 1초/128MB
알고리즘 분류 : 구현

알고리즘 설명
1. 정렬 후 ABC가 인덱스에 매핑

채점 결과 : 152ms/16056KB
풀이 날짜 : 2021/11/28
*/

public class B3047 {
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        num = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        char[] input = br.readLine().toCharArray();
        for (char c : input) {
            bw.write(num[c - 'A'] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
