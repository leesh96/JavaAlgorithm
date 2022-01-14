package baekjoon.simulation.silver4;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2331
문제제목 : 반복수열
난이도 : 실버 4
제한사항 : 2초/256MB
알고리즘 분류 : 수학, 구현

알고리즘 설명
1. 집합 사용
2. 첫 번째 수를 기본 집합에 넣고
3. 다음 수를 만들고 기본 집합에 존재할 때부턴 중복 집합에 넣는다.
4. 계속 진행하면서 기본 집합과 중복 집합에 수가 모두 존재하면 종료
5. 기본 집합에서 중복 집합을 뺀 차집합의 크기가 정답

채점 결과 : 132ms/14240KB
풀이 날짜 : 2022/01/14
*/

public class B2331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        HashSet<Integer> origin = new HashSet<>();
        HashSet<Integer> duplicate = new HashSet<>();
        origin.add(n);
        int cur = n;
        while (true) {
            int temp = 0;
            while (cur > 0) {
                temp += (int) Math.pow(cur % 10, p);
                cur /= 10;
            }

            if (origin.contains(temp) && duplicate.contains(temp)) {
                break;
            } else if (origin.contains(temp)) {
                duplicate.add(temp);
            } else {
                origin.add(temp);
            }

            cur = temp;
        }

        origin.removeAll(duplicate);
        bw.write(String.valueOf(origin.size()));
        bw.flush();
        bw.close();
        br.close();
    }
}
