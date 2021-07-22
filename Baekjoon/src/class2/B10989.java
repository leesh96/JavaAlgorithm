package class2;

import java.io.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 10989
 * 문제제목 : 수 정렬하기 3
 * 난이도 : 실버 5
 * 제한사항 : 3초/8MB(자바 3초/512MB)
 * 알고리즘 분류 : 정렬
 *
 * 알고리즘 설명
 * nlogn의 병합정렬과 n의 계수정렬
 *
 * 채점 결과 : 병합정렬 2984ms/381604KB, 계수정렬 1880ms/300732KB
 * 풀이 날짜 : 2021/07/22
**/

public class B10989 {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[10001];
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }
        for (int i = 1; i <= 10000; i++) {
            while (arr[i] > 0) {
                bw.write(i + "\n");
                arr[i]--;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
