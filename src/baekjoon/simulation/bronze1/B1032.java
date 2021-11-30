package baekjoon.simulation.bronze1;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 1032
문제제목 : 명령 프롬프트
난이도 : 브론즈 1
제한사항 : 2초/128MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 문자열 전부 비교
2. 각 위치에서 문자가 다른 문자열이 하나라도 있으면 그 자리는 ? 출력

채점 결과 : 132ms/14268KB
풀이 날짜 : 2021/11/30
*/

public class B1032 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < arr[0].length(); i++) {
            boolean flag = false;

            for (int j = 0; j < n - 1; j++) {
                if (arr[j].charAt(i) != arr[j+1].charAt(i)) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                bw.write("?");
            } else {
                bw.write(arr[0].charAt(i));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
