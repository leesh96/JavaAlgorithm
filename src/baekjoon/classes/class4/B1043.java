package baekjoon.classes.class4;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1043
문제제목 : 거짓말
난이도 : 골드 4
제한사항 : 2초/128MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, 자료구조, 유니온파인드

알고리즘 설명
1. 사람들이 진실을 아는 사람인지 아닌지를 저장하는 부울 배열 선언, 정보 저장
2. 파티 멤버를 저장하면서 같은 파티의 참석 멤버를 union => 같은 parent를 가지게 된다.
3. 사람들의 parent(연관관계)가 변경되었기 때문에 진실을 아는 사람의 parent도 진실을 아는 사람이 된다.
4. 각 파티에 대해서 파티 멤버들의 parent(모든 멤버의 parent는 동일)가 진실을 아는 사람이 아니라면 answer++;

채점 결과 : 132ms/14296KB
풀이 날짜 : 2021/11/03
*/

public class B1043 {
    static int n, m;
    static boolean[] truePeople;
    static int[] parent;
    static ArrayList<Integer>[] party;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        truePeople = new boolean[n+1];
        st = new StringTokenizer(br.readLine());
        int tpSize = Integer.parseInt(st.nextToken());
        for (int i = 0; i < tpSize; i++) {
            int person = Integer.parseInt(st.nextToken());
            truePeople[person] = true;
        }

        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        party = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int ptSize = Integer.parseInt(st.nextToken());

            int prev = Integer.parseInt(st.nextToken());
            party[i].add(prev);
            for (int j = 1; j < ptSize; j++) {
                int cur = Integer.parseInt(st.nextToken());
                party[i].add(cur);
                union(prev, cur);
                prev = cur;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (truePeople[i]) {
                truePeople[find(i)] = true;
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            if (!truePeople[find(party[i].get(0))]) answer++;
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}
