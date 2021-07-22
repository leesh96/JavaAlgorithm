package class2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 10814
 * 문제제목 : 나이순 정렬
 * 난이도 : 실버 5
 * 제한사항 : 3초/256MB
 * 알고리즘 분류 : 정렬
 *
 * 알고리즘 설명
 * Comparable 구현
 *
 * 채점 결과 : 576ms/55140KB
 * 풀이 날짜 : 2021/07/17
**/

public class B10814 {
    static int n;
    static user[] list;

    static class user implements Comparable<user> {
        int age, idx;
        String name;

        public user(int i, int a, String n) {
            this.idx = i;
            this.age = a;
            this.name = n;
        }

        @Override
        public int compareTo(user o) {
            if (this.age == o.age) {
                return this.idx - o.idx;
            } else {
                return this.age - o.age;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        list = new user[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list[i] = new user(i, age, name);
        }

        Arrays.sort(list);

        for (int i = 0; i < n; i++) {
            bw.write(list[i].age + " " + list[i].name + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
