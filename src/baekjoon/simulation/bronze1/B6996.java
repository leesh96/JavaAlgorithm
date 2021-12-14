package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 6996
문제제목 : 애너그램
난이도 : 브론즈 1
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 두 문자열을 문자 배열로 바꾼 후 정렬해서 같은지 비교

채점 결과 : 140ms/14532KB
풀이 날짜 : 2021/12/14
*/

public class B6996 {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            char[] aArr = a.toCharArray();
            char[] bArr = b.toCharArray();
            Arrays.sort(aArr);
            Arrays.sort(bArr);

            if (Arrays.equals(aArr, bArr)) {
                bw.write(String.format("%s & %s are anagrams.\n", a, b));
            } else {
                bw.write(String.format("%s & %s are NOT anagrams.\n", a, b));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
