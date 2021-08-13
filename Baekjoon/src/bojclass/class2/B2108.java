package bojclass.class2;

import java.io.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 2108
 * 문제제목 : 통계학
 * 난이도 : 실버 4
 * 제한사항 : 2초/256MB
 * 알고리즘 분류 : 구현, 정렬
 *
 * 알고리즘 설명
 * 계수 정렬을 이용한 산술 통계
 *
 * 채점 결과 : 352ms/42036KB
 * 풀이 날짜 : 2021/07/22
**/

public class B2108 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[8001];
        double sum = 0.0;
        int max = -4001;
        int min = 4001;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            arr[input + 4000]++;
            sum += input;

            if (max < input) {
                max = input;
            }

            if (input < min) {
                min = input;
            }
        }

        int median = 10000;
        int mode = 10000;
        int idx = 0;
        int modeMax = 0;
        boolean isSole = false;

        for (int i = min + 4000; i <= max + 4000; i++) {
            if (arr[i] > 0) {
                if (idx < (n + 1) / 2) {
                    idx += arr[i];
                    median = i - 4000;
                }
            }

            if (modeMax < arr[i]) {
                modeMax = arr[i];
                mode = i - 4000;
                isSole = true;
            } else if (modeMax == arr[i] && isSole) {
                mode = i - 4000;
                isSole = false;
            }
        }

        bw.write(((int)Math.round(sum / n)) + "\n");
        bw.write(median + "\n");
        bw.write(mode + "\n");
        bw.write((max - min) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
