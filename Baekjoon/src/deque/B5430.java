package deque;

import java.io.*;
import java.util.LinkedList;

/**
 * 플랫폼 : 백준
 * 문제번호 : 5430
 * 문제제목 : AC
 * 난이도 : 골드 5
 * 제한사항 : 1초/256MB
 * 알고리즘 분류 : 덱, 문자열, 파싱
 *
 * 알고리즘 설명
 * 문제에 주어진 조건의 예외처리가 관건
 * 1. 명령어 있는데 숫자 배열이 없는 경우 -> 문자열 파싱하면 안됌 -> 빈 데크로 놔야지..
 * 2. 빈 덱에서 D 명령을 수행하는 경우
 *
 * 채점 결과 : 904ms/139792KB
 * 풀이 날짜 : 2021/07/16
**/

public class B5430 {
    static int t, n;
    static char[] order;
    static LinkedList<Integer> deque;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());

        for (int c = 0; c < t; c++) {
            order = br.readLine().trim().toCharArray();
            n = Integer.parseInt(br.readLine());
            deque = new LinkedList<>();
            String input = br.readLine();
            if (n != 0) {
                String[] nums = input.replace("[", "").replace("]", "").split(",");
                for (int i = 0; i < nums.length; i++) {
                    deque.add(Integer.parseInt(nums[i]));
                }
            }

            boolean isReverse = false;
            boolean isError = false;
            for (int i = 0; i < order.length; i++) {
                if (order[i] == 'R') {
                    isReverse = !isReverse;
                } else if(order[i] == 'D') {
                    if (deque.isEmpty()) {
                        bw.write("error\n");
                        isError = true;
                        break;
                    }
                    if (isReverse) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            if (!isError) {
                StringBuilder temp = new StringBuilder("[");
                if (!deque.isEmpty()) {
                    if (isReverse) {
                        while (deque.size() > 1) {
                            temp.append(deque.removeLast()).append(",");
                        }
                        temp.append(deque.removeLast());
                    } else {
                        while (deque.size() > 1) {
                            temp.append(deque.removeFirst()).append(",");
                        }
                        temp.append(deque.removeFirst());
                    }
                }
                temp.append("]");
                bw.write(temp + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
