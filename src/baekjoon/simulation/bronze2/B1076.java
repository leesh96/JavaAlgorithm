package baekjoon.simulation.bronze2;

import java.io.*;
import java.util.HashMap;

/*
플랫폼 : 백준
문제번호 : 1076
문제제목 : 저항
난이도 : 브론즈 2
제한사항 : 2초/128MB
알고리즘 분류 : 구현

알고리즘 설명
1. 정답은 long형 범위임에 유의
2. map에 값을 넣어놓고 값의 10의 거듭제곱이 곱임.

채점 결과 : 128ms/14360KB
풀이 날짜 : 2021/11/23
*/

public class B1076 {
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        map.put("black", 0);
        map.put("brown", 1);
        map.put("red", 2);
        map.put("orange", 3);
        map.put("yellow", 4);
        map.put("green", 5);
        map.put("blue", 6);
        map.put("violet", 7);
        map.put("grey", 8);
        map.put("white", 9);

        int value = 0;
        for (int i = 0; i < 2; i++) {
            value = value * 10 + map.get(br.readLine());
        }

        long answer = value;
        int multi = map.get(br.readLine());
        answer *= (long) Math.pow(10, multi);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
