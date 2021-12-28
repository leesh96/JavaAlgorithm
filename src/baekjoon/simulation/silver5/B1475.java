package baekjoon.simulation.silver5;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
플랫폼 : 백준
문제번호 : 1475
문제제목 : 방 번호
난이도 : 실버 5
제한사항 : 2초/128MB
알고리즘 분류 : 구현

알고리즘 설명
1. Map에 숫자 개수를 count한다.
2. 6, 9를 같은 숫자로 취급해서 count
3. 6, 9 등장횟수의 합이 홀수이면 / 2 + 1, 아니면 / 2

채점 결과 : 140ms/14312KB
풀이 날짜 : 2021/12/26
*/

public class B1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        while (n > 0) {
            int key = n % 10;
            if (key == 9) {
                key = 6;
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
            n /= 10;
        }

        if (map.getOrDefault(6, 0) % 2 == 1) {
            map.put(6, (map.getOrDefault(6, 0) / 2) + 1);
        } else {
            map.put(6, map.getOrDefault(6, 0) / 2);
        }
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
