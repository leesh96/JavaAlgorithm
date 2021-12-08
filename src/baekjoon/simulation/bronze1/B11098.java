package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
플랫폼 : 백준
문제번호 : 11098
문제제목 : 첼시를 도와줘!
난이도 : 브론즈 1
제한사항 : 1초/256MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 선수들의 가격에 중복값이 없으므로 힙 기반의 TreeMap 사용
2. TreeMap을 최대 힙으로 두고 첫번째 엔트리의 값 출력

채점 결과 : 208ms/17372KB
풀이 날짜 : 2021/12/08
*/

public class B11098 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int t = Integer.parseInt(br.readLine());
            TreeMap<Integer, String> player = new TreeMap<>(((o1, o2) -> o2 - o1));
            while (t-- > 0) {
                st = new StringTokenizer(br.readLine());
                int price = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                player.put(price, name);
            }

            bw.write(player.firstEntry().getValue() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
