package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.*;

/*
플랫폼 : 백준
문제번호 : 2456
문제제목 : 나는 학급회장이다
난이도 : 브론즈 1
제한사항 : 1초/128MB
알고리즘 분류 : 구현

알고리즘 설명
1. 후보들 점수를 담는 클래스 선언
2. Comparator 구현으로 정렬
3. 정렬된 리스트의 첫번째와 두번째를 비교해서 후보를 낼 수 없는 조건인지 확인

채점 결과 : 160ms/14932KB
풀이 날짜 : 2021/12/14
*/

public class B2456 {
    static int n;

    static class Score implements Comparator<Score> {
        int idx, sum, first, second, third;

        public Score(int idx) {
            this.idx = idx;
        }

        @Override
        public int compare(Score o1, Score o2) {
            if (o1.sum == o2.sum) {
                if (o1.third == o2.third) {
                    if (o1.second == o2.second) {
                        return 0;
                    }
                    return o2.second - o1.second;
                }
                return o2.third - o1.third;
            }
            return o2.sum - o1.sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        ArrayList<Score> arr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            arr.add(new Score(i));
        }
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());

            add(arr, first, 0);
            add(arr, second, 1);
            add(arr, third, 2);
        }

        arr.sort((o1, o2) -> {
            if (o1.sum == o2.sum) {
                if (o1.third == o2.third) {
                    if (o1.second == o2.second) {
                        return 0;
                    }
                    return o2.second - o1.second;
                }
                return o2.third - o1.third;
            }
            return o2.sum - o1.sum;
        });
        if (arr.get(0).compare(arr.get(0), arr.get(1)) == 0) {
            bw.write(String.format("%d %d", 0, arr.get(0).sum));
        } else {
            bw.write(String.format("%d %d", arr.get(0).idx+1, arr.get(0).sum));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void add(ArrayList<Score> arr, int value, int idx) {
        if (value == 1) {
            arr.get(idx).first++;
        } else if (value == 2) {
            arr.get(idx).second++;
        } else {
            arr.get(idx).third++;
        }
        arr.get(idx).sum += value;
    }
}
