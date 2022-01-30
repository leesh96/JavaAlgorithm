package baekjoon.subjects.queue;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 3078
 * 문제제목 : 좋은 친구
 * 난이도 : 골드 3
 * 제한사항 : 1초/128MB
 * 알고리즘 분류 : 큐
 *
 * 알고리즘 설명
 * 1. 글자길이의 큐 리스트 선언
 * 2. 입력 받으면 글자 길이의 큐가 비어 있으면 인덱스 삽입 -> 좋은 친구 쌍도 존재하지 않음
 * 3. 비어 있지 않으면 인덱스가 등수 구간 밖에 있는 원소 삭제
 * 4. 중간에 큐가 비어있으면 멈춤
 * 5. 구간 밖에 있는 원소 삭제 끝났으면 현재 같은 이름 길이의 큐 사이즈가 좋은 친구 쌍
 * 6. 정답에 더해주고 큐에 현재 입력 값 삽입
 *
 * 채점 결과 : 284ms/50136KB
 * 풀이 날짜 : 2021/07/14
**/

public class B3078 {
    static int n, k;
    static LinkedList<Integer>[] queue = new LinkedList[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 21; i++) {
            queue[i] = new LinkedList<>();
        }

        long answer = 0;
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            int length = name.length();

            if (queue[length].isEmpty()) {
                queue[length].offer(i);
            } else {
                while (queue[length].peek() + k < i) {
                    queue[length].poll();
                    if (queue[length].isEmpty()) {
                        break;
                    }
                }
                answer += queue[length].size();
                queue[length].offer(i);
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
