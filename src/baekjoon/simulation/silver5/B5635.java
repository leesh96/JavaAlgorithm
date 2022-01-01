package baekjoon.simulation.silver5;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
플랫폼 : 백준
문제번호 : 5635
문제제목 : 생일
난이도 : 실버 5
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 정렬

알고리즘 설명
1. 생년월일을 담는 클래스 선언
2. Treemap에 Birth-Name 으로 저장
3. 첫번째 엔트리와 마지막 엔트리의 이름 출력

채점 결과 : 136ms/14188KB
풀이 날짜 : 2022/01/01
*/

public class B5635 {

    static class Birth {
        int year, month, day;

        public Birth(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        TreeMap<Birth, String> map = new TreeMap<>(((o1, o2) -> {
            if (o1.year == o2.year) {
                if (o1.month == o2.month) {
                    return o1.day - o2.day;
                }
                return o1.month - o2.month;
            }
            return o1.year - o2.year;
        }));

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            map.put(new Birth(year, month, day), name);
        }

        bw.write(map.lastEntry().getValue() + "\n");
        bw.write(map.firstEntry().getValue() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
