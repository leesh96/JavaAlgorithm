package baekjoon.classes.class4;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 15666
문제제목 : N과 M (12)
난이도 : 실버 2
제한사항 : 2초/512MB
알고리즘 분류 : 백트래킹

알고리즘 설명
1. 중복 조합 구하기. 단, 배열에 숫자가 중복해서 들어있어서 LinkedHashSet으로 중복 결과 제거

채점 결과 : 196ms/18148KB
풀이 날짜 : 2021/10/19
*/

public class B15666 {
    static int n, m;
    static int[] arr;
    static LinkedHashSet<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        result = new LinkedHashSet<>();
        dfs(new int[m], 0, 0);
        for (String s : result) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int[] res, int depth, int cur) {
        if (depth == m) {
            StringBuilder temp = new StringBuilder();
            for (int r : res) {
                temp.append(r).append(" ");
            }
            result.add(temp.toString().trim());
            return;
        }

        for (int i = cur; i < n; i++) {
            res[depth] = arr[i];
            dfs(res, depth + 1, i);
        }
    }
}
