package baekjoon.classes.class2;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 10816
 * 문제제목 : 숫자 카드 2
 * 난이도 : 실버 4
 * 제한사항 : 1초/256MB
 * 알고리즘 분류 : 해시를 사용한 집합과 맵, 이분 탐색
 *
 * 알고리즘 설명
 * 해시 맵으로 구현
 * 이분 탐색의 upperbound, lowerbound 구현해보기
 *
 * 채점 결과 : 1296ms/274224KB
 * 풀이 날짜 : 2021/07/18
**/

public class B10816 {
    static int n, m;
    static HashMap<Integer, Integer> num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        num = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            num.put(input, num.getOrDefault(input, 0) + 1);
        }
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int find = Integer.parseInt(st.nextToken());
            if (num.containsKey(find)) {
                bw.write(num.get(find) + " ");
            } else {
                bw.write("0 ");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
