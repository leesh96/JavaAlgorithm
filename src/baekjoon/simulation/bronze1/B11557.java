package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
플랫폼 : 백준
문제번호 : 11557
문제제목 : Yangjojang of The Year
난이도 : 브론즈 1
제한사항 : 1초/256MB
알고리즘 분류 : 구현

알고리즘 설명
1. 같은 테스트케이스 내에서 동일한 술의 양을 가지는 학교는 없으므로
2. TreeMap 자료구조 사용

채점 결과 : 128ms/14280KB
풀이 날짜 : 2021/12/05
*/

public class B11557 {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            TreeMap<Integer, String> map = new TreeMap<>(((o1, o2) -> o2 - o1));

            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String school = st.nextToken();
                int drink = Integer.parseInt(st.nextToken());

                map.put(drink, school);
            }

            bw.write(map.firstEntry().getValue() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
