package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;

/*
플랫폼 : 백준
문제번호 : 4641
문제제목 : Doubles
난이도 : 브론즈 1
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 브루트포스 알고리즘

알고리즘 설명
1. 집합에 담고 모든 원소에 대해 2배인 수가 집합에 존재하는지 확인
2. HashTable 기반의 HashSet 자료구조 사용

채점 결과 : 144ms/14600KB
풀이 날짜 : 2021/12/15
*/

public class B4641 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] input = br.readLine().split(" ");

            if (input[0].equals("-1")) {
                break;
            }

            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < input.length; i++) {
                set.add(Integer.parseInt(input[i]));
            }

            Iterator<Integer> it = set.iterator();
            int count = 0;
            while (it.hasNext()) {
                int n = it.next();

                if (n == 0) {
                    continue;
                }

                if (set.contains(n * 2)) {
                    count++;
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
