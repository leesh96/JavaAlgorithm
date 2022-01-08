package baekjoon.simulation.silver5;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
플랫폼 : 백준
문제번호 : 2535
문제제목 : 아시아 정보올림피아드
난이도 : 실버 5
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 정렬

알고리즘 설명
1. 국가번호와 학생번호를 담을 클래스 선언
2. 최대힙 기반 TreeMap에 점수-학생정보 쌍으로 데이터 집어넣고
3. 하나씩 빼면서(점수가 높은 순으로 빠짐) 해당 나라의 메달 수 확인
4. 조건 확인하고 출력, 국가별 메달 수 갱신

채점 결과 : 140ms/14600KB
풀이 날짜 : 2022/01/08
*/

public class B2535 {

    static class Student {
        int nation, idx;

        public Student(int nation, int idx) {
            this.nation = nation;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        TreeMap<Integer, Student> map = new TreeMap<>(((o1, o2) -> o2 - o1));
        HashMap<Integer, Integer> count = new HashMap<>();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            Student std = new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            int score = Integer.parseInt(st.nextToken());

            map.put(score, std);
        }

        int medal = 3;
        while (!map.isEmpty() && medal > 0) {
            Map.Entry<Integer, Student> cur = map.pollFirstEntry();

            if (count.getOrDefault(cur.getValue().nation, 0) < 2) {
                medal--;
                count.put(cur.getValue().nation, count.getOrDefault(cur.getValue().nation, 0) + 1);
                bw.write(String.format("%d %d\n", cur.getValue().nation, cur.getValue().idx));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
