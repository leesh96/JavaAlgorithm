package baekjoon.simulation;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1592
문제제목 : 영식이와 친구들
난이도 : 브론즈 2
제한사항 : 2초/128MB
알고리즘 분류 : 구현, 시뮬레이션

알고리즘 설명
1. 공을 받은 횟수를 기록하는 배열 만들고
2. 인덱스를 조건에 맞게 조작
3. 인덱스가 배열 범위를 벗어나는 경우에 대해 처리
4. 공 받은 횟수와 공 던진 횟수 증가

채점 결과 : 136ms/14368KB
풀이 날짜 : 2021/11/14
*/

public class B1592 {
    static int n, m, l;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        count = new int[n+1];
        count[1] = 1;
        int idx = 1;
        int answer = 0;

        while (count[idx] != m) {

            if (count[idx] % 2 == 0) {
                idx -= l;
            } else {
                idx += l;
            }

            if (idx > n) {
                idx %= n;
            } else if (idx < 1) {
                idx += n;
            }

            count[idx]++;
            answer++;
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
