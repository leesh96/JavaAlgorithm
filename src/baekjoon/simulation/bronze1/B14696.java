package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 14696
문제제목 : 딱지놀이
난이도 : 브론즈 1
제한사항 : 2초/512MB
알고리즘 분류 : 구현

알고리즘 설명
1. 카드 숫자 개수 카운트
2. 비교

채점 결과 : 296ms/28696KB
풀이 날짜 : 2021/12/09
*/

public class B14696 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int[] aCard = new int[5];
            int[] bCard = new int[5];

            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            for (int i = 0; i < length; i++) {
                aCard[Integer.parseInt(st.nextToken())]++;
            }

            st = new StringTokenizer(br.readLine());
            length = Integer.parseInt(st.nextToken());
            for (int i = 0; i < length; i++) {
                bCard[Integer.parseInt(st.nextToken())]++;
            }

            boolean flag = false;
            for (int i = 4; i >= 1; i--) {
                if (aCard[i] > bCard[i]) {
                    bw.write("A\n");
                    flag = true;
                    break;
                } else if (aCard[i] < bCard[i]) {
                    bw.write("B\n");
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                bw.write("D\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
