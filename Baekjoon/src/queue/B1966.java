package queue;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1966
 * 문제제목 : 프린터 큐
 * 난이도 : 실버 3
 * 제한사항 : 2초/128MB
 * 알고리즘 분류 : 큐, 시뮬레이션
 *
 * 알고리즘 설명
 * 1. 문서의 인덱스와 중요도를 담을 클래스 선언
 * 2. 프린터 큐에 문서를 넣음 (인덱스 : 입력 순서, 중요도 : 값)
 * 3. 현재 프린터 큐의 head 문서의 중요도 확인
 * 4. 프린터 큐에 중요도가 높은 문서 하나라도 있으면 가장 뒤로 재배치
 * 5. 프린터 큐에 head에 가장 높은 문서가 올 수 있도록 다른 문서도 재배치
 * 6. 문서 출력 순서 출력
 *
 * 채점 결과 : 120ms/12796KB
 * 풀이 날짜 : 2021/07/14
**/

public class B1966 {
    static int c, n, m;
    static LinkedList<document> printQ;

    static class document {
        int idx;
        int priority;

        public document(int i, int p) {
            this.idx = i;
            this.priority = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        c = Integer.parseInt(br.readLine());
        for (int t = 0; t < c; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            printQ = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i ++) {
                printQ.offer(new document(i, Integer.parseInt(st.nextToken())));
            }

            int order = 0;
            while (!printQ.isEmpty()) {
                document front = printQ.poll();
                boolean isPrint = true;
                for (int i = 0; i < printQ.size(); i++) {
                    if (front.priority < printQ.get(i).priority) {
                        printQ.offer(front);
                        for (int j = 0; j < i; j++) {
                            printQ.offer(printQ.poll());
                        }
                        isPrint = false;
                        break;
                    }
                }

                if (!isPrint) {
                    continue;
                }

                order++;
                if (front.idx == m) {
                    break;
                }
            }
            bw.write(order + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
