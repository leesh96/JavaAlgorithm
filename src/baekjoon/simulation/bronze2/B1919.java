package baekjoon.simulation.bronze2;

import java.io.*;
import java.util.Arrays;

/*
플랫폼 : 백준
문제번호 : 1919
문제제목 : 애너그램 만들기
난이도 : 브론즈 2
제한사항 : 2초/128MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 각 문자열에 등장하는 알파벳수를 카운트
2. 한쪽은 더하고 한쪽은 빼면 차이를 알 수 있음
3. 0인 알파벳들은 셀 필요가 없음
4. 알파벳수 카운트 합계 출력

채점 결과 : 128ms/14308KB
풀이 날짜 : 2021/11/28
*/

public class B1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] first = br.readLine().toCharArray();
        char[] second = br.readLine().toCharArray();
        int[] alpha = new int[26];
        for (char c : first) {
            alpha[c - 'a']++;
        }
        for (char c : second) {
            alpha[c - 'a']--;
        }
        bw.write(Arrays.stream(alpha).map(Math::abs).sum() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
