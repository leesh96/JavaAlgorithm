package baekjoon.simulation.silver4;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1783
문제제목 : 병든 나이트
난이도 : 실버 4
제한사항 : 2초/128MB
알고리즘 분류 : 구현, 그리디 알고리즘, 많은 조건 분기

알고리즘 설명
1. n이 1이면 아무데도 이동할 수 없기 때문에 항상 1
2. n이 2이면
오른쪽으로 두 칸씩 이동할 수 있음 -> 5회부터는 4가지 이동 조건을 모두 1번씩은 써야 이동가능 하기 때문에 최대 4번까지는 가능
3. 가로 길이의 제한 m < 7인 경우
오른쪽으로 최대한 촘촘하게 가는게 이득 -> 이동 횟수 5회부터는 조건을 충족해야하기 때문에 가로 길이를 넘어가지 않는 선에서 최대로 이동할 수 있는 방법을 찾아야 한다.
4. 아무 제약이 없으면
최소 4칸은 이동가능하고 가로 길이에서 6만큼 더 갔기 때문에 7만큼 뺀 칸을 이동할 수 있다.


채점 결과 : 132ms/14264KB
풀이 날짜 : 2022/01/15
*/

public class B1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int count;
        if (n == 1) {
            count = 0;
        } else if (n == 2) {
            count = (m - 1) / 2;
            count = Math.min(count, 3);
        } else if (m < 7) {
            count = m - 1;
            count = Math.min(count, 3);
        } else {
            count = 4 + m - 7;
        }

        bw.write(String.valueOf(count + 1));
        bw.flush();
        bw.close();
        br.close();
    }
}
