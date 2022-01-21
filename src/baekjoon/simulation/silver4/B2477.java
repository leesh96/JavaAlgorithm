package baekjoon.simulation.silver4;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2477
문제제목 : 참외밭
난이도 : 실버 4
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 기하학, 애드 혹

알고리즘 설명
변의 방향은 필요 없음
1. 6각형이 ㄱ자 모양(혹은 이를 뒤집은 모양)을 하기 때문에 인접한 두 변을 곱해서 더해보면
2. 육각형의 넓이 * 3과 전체 사각형에서 파인 모양의 넓이 * 2의 합과 같아진다.
3. 이를 이용해서 파인 넓이를 구할 수 있으므로
4. 육각형의 온전한 넓이를 구할 수 있다.

채점 결과 : 120ms/14216KB
풀이 날짜 : 2022/01/21
*/

public class B2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());

        int total = 0;
        int ext = 0;
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        int first = Integer.parseInt(st.nextToken());
        int prev = first;
        for (int i = 1; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int cur = Integer.parseInt(st.nextToken());
            int curExt = cur * prev;
            total = Math.max(total, curExt);
            ext += curExt;
            prev = cur;
        }
        total = Math.max(total, prev * first);
        ext += prev * first;

        bw.write(String.valueOf((total - ((total * 3) - ext)) * k));
        bw.flush();
        bw.close();
        br.close();
    }
}
