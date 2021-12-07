package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
플랫폼 : 백준
문제번호 : 1145
문제제목 : 적어도 대부분의 배수
난이도 : 브론즈 1
제한사항 : 2초/128MB
알고리즘 분류 : 브루트포스 알고리즘, 수학

알고리즘 설명
1. 유클리드 호제법을 이용한 최대 공약수, 최대 공약수를 활용한 최소 공배수 공식 사용
2. 숫자 3개를 선택하는 조합을 구해서 해당 조합의 최소 공배수를 구하고
3. TreeMap에 넣어서 최소값 출력

채점 결과 : 128ms/14312KB
풀이 날짜 : 2021/12/07
*/

public class B1145 {
    static int[] arr;
    static TreeSet<Integer> multiplies = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        arr = new int[5];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        makeComb(new int[3], 0, 0);

        bw.write(multiplies.first() + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void makeComb(int[] result, int depth, int idx) {
        if (depth == 3) {
            // 세 수의 최소 공배수 찾기
            /*int temp = result[0];
            for (int i = 0; i < 3; i++) {
                temp = lcm(temp, result[i]);
            }*/
            int temp = lcm(lcm(result[0], result[1]), result[2]);
            multiplies.add(temp);
            return;
        }

        for (int i = idx; i < 5; i++) {
            result[depth] = arr[i];
            makeComb(result, depth + 1, i + 1);
        }
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
