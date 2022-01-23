package baekjoon.simulation.silver4;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
플랫폼 : 백준
문제번호 : 2621
문제제목 : 카드게임
난이도 : 실버 4
제한사항 : 1초/128MB
알고리즘 분류 : 구현

알고리즘 설명
완전 구현 문제임
등장한 숫자를 크기 순서로 받을 TreeSet
등장한 색을 받을 LinkedHashSet
숫자별로 등장한 횟수를 세기 위한 배열
숫자 중 가장 큰 수를 기록하는 변수
이거 4개를 가지고 조건 충족하는지 확인

채점 결과 : 140ms/14328KB
풀이 날짜 : 2022/01/23
*/

public class B2621 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] numberCount = new int[10];
        TreeSet<Integer> numbers = new TreeSet<>();
        LinkedHashSet<String> colors = new LinkedHashSet<>();
        int maxNum = Integer.MIN_VALUE;
        int score = Integer.MIN_VALUE;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            int n = Integer.parseInt(st.nextToken());

            numberCount[n]++;
            maxNum = Math.max(maxNum, n);
            numbers.add(n);
            colors.add(c);
        }

        if (numbers.size() == 5) {
            int minMaxGap = numbers.last() - numbers.first();

            if (minMaxGap == 4 && colors.size() == 1) {
                score = Math.max(score, maxNum + 900);
            } else if(minMaxGap == 4) {
                score = Math.max(score, maxNum + 500);
            }
        }

        if (numbers.size() == 2) {
            if (numberCount[numbers.first()] == 4) {
                score = Math.max(score, numbers.first() + 800);
            } else if (numberCount[numbers.last()] == 4) {
                score = Math.max(score, numbers.last() + 800);
            }

            if (numberCount[numbers.first()] == 3 && numberCount[numbers.last()] == 2) {
                score = Math.max(score, numbers.first() * 10 + numbers.last() + 700);
            } else if (numberCount[numbers.first()] == 2 && numberCount[numbers.last()] == 3) {
                score = Math.max(score, numbers.last() * 10 + numbers.first() + 700);
            }
        } else if (numbers.size() == 3) {
            for (int n : numbers) {
                if (numberCount[n] == 3) {
                    score = Math.max(score, n + 400);
                }
            }

            for (int f : numbers) {
                for (int s : numbers) {
                    if (f == s) continue;
                    if (numberCount[f] == 2 && numberCount[s] == 2) {
                        score = Math.max(score, Math.max(f, s) * 10 + Math.min(f, s) + 300);
                    }
                }
            }
        } else if (numbers.size() == 4) {
            for (int n : numbers) {
                if (numberCount[n] == 2) {
                    score = Math.max(score, n + 200);
                    break;
                }
            }
        }

        if (colors.size() == 1) {
            score = Math.max(score, maxNum + 600);
        }

        if (score == Integer.MIN_VALUE) {
            score = maxNum + 100;
        }

        bw.write(String.valueOf(score));
        bw.flush();
        bw.close();
        br.close();
    }
}
