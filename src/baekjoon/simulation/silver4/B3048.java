package baekjoon.simulation.silver4;

import java.io.*;
import java.util.*;

/*
플랫폼 : 백준
문제번호 : 3048
문제제목 : 개미
난이도 : 실버4
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 문자열, 시뮬레이션

알고리즘 설명
1. 집합 두개에 개미들을 담아놓고
2. 길에 쭉 나열
3. 각 초마다 앞에서 부터 개미 2마리씩 비교하면서
4. 현재 개미가 1집합이고 다음 개미가 2집합일 때 서로 교환

채점 결과 : 124ms/14188KB
풀이 날짜 : 2022/01/29
*/

public class B3048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        ArrayList<Character> road = new ArrayList<>();
        HashSet<Character> s1 = new HashSet<>();
        String input = br.readLine();
        for (int i = n1-1; i >= 0; i--) {
            char cur = input.charAt(i);
            s1.add(cur);
            road.add(cur);
        }
        HashSet<Character> s2 = new HashSet<>();
        input = br.readLine();
        for (int i = 0; i < n2; i++) {
            char cur = input.charAt(i);
            s2.add(cur);
            road.add(cur);
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            for (int i = 0; i < road.size() - 1; i++) {
                char cur = road.get(i);
                char next = road.get(i+1);
                if (!s2.contains(cur) && (s1.contains(cur) && s2.contains(next))) {
                    road.set(i, next);
                    road.set(i+1, cur);
                    i++;
                }
            }
        }

        for (char c : road) {
            bw.write(c);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
