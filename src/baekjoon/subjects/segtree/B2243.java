package baekjoon.subjects.segtree;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 2243
 * 문제제목 : 사탕상자
 * 난이도 : 플래티넘 5
 * 제한사항 : 2초/128MB
 * 알고리즘 분류 : 세그먼트 트리, 이분 탐색
 *
 * 알고리즘 설명
 * 1. 사탕의 정보 입력받고 세그먼트 트리 초기화
 * 2. 사탕을 넣는 경우, 세그먼트 트리의 b 인덱스의 값을 c로 변경
 * 3. 사탕을 꺼내는 경우, 세그먼트 트리의 구간합(저장된 사탕의 개수)을 구해 몇번째 사탕인지 알아야한다. -> 이분탐색 적용
 * 4. 구간합이 b보다 작을 경우 구간 늘려줘야 한다.
 * 5. 세그먼트 트리의 start 인덱스 사탕 수를 1만큼 빼준다. (사탕 꺼내기)
 * 6. 주어진 모든 연산에 대해 수행
 *
 * 채점 결과 : 1268ms/87104KB
 * 풀이 날짜 : 2021/07/10
**/

public class B2243 {
    static final int MAX = 1000000;
    static int n;
    static long[] segTree;
    static int segN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for (segN = 1; segN < MAX; segN *= 2);
        segTree = new long[(int)(1 * Math.pow(2, (int)Math.ceil(Math.log10(segN) / Math.log10(2)) + 1))];
        create(1, 1, MAX);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                long b = Long.parseLong(st.nextToken());
                int start = 1;
                int end = MAX;

                while (start <= end) {
                    int mid = (start + end) / 2;
                    long sectSum = sum(1, MAX, 1, 1, mid);

                    if (sectSum < b) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }

                bw.write(start + "\n");
                update(1, MAX, 1, start, -1);
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                update(1, MAX, 1, b, c);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static long create(int node, int start, int end) {
        if (start == end) {
            return segTree[node] = 0;
        }
        int mid = (start + end) / 2;
        return segTree[node] = create(node * 2, start, mid) + create(node * 2 + 1, mid + 1, end);
    }

    static void update(int start, int end, int node, int idx, long diff) {
        if (idx < start || idx > end) {
            return;
        }

        segTree[node] += diff;

        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, diff);
        update(mid + 1, end, node * 2 + 1, idx, diff);
    }

    static long sum(int start, int end, int node, int left, long right) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && end <= right) {
            return segTree[node];
        }

        int mid = (start + end) / 2;

        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }
}
