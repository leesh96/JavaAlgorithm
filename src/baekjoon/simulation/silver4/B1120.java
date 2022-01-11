package baekjoon.simulation.silver4;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1120
문제제목 : 문자열
난이도 : 실버 4
제한사항 : 2초/128MB
알고리즘 분류 : 문자열, 브루트포스 알고리즘

알고리즘 설명
1. a의 길이는 b의 길이보다 항상 같거나 작음
2. a가 시작할 수 있는 b의 인덱스부터 각 자리 문자 비교 (앞, 뒤에만 추가 가능하기 때문)
3. 최소값을 갱신

채점 결과 : 128ms/14284KB
풀이 날짜 : 2022/01/11
*/

public class B1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < b.length() - a.length() + 1; i++) {
            int temp = 0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(i + j)) {
                    temp++;
                }
            }
            min = Math.min(min, temp);
        }
        bw.write(min + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
