package baekjoon.simulation.bronze1;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 2851
문제제목 : 슈퍼 마리오
난이도 : 브론즈 1
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 브루트포스 알고리즘

알고리즘 설명
1. 이전까지의 합계와 현재 먹은 버섯까지의 합 두 개의 변수를 확인
2. 현재 먹은 버섯까지의 합이 100이상이 되면 종료
3. 두 변수와 100의 차이를 비교하여 정답 출력

채점 결과 : 132ms/14128KB
풀이 날짜 : 2021/12/04
*/

public class B2851 {
    static int[] mushroom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        mushroom = new int[10];

        for (int i = 0; i < 10; i++) {
            mushroom[i] = Integer.parseInt(br.readLine());
        }

        int last = 0;
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = last + mushroom[i];

            if (last < sum && sum < 100) {
                last = last + mushroom[i];
            } else if (sum >= 100) {
                break;
            }
        }

        if (sum - 100 > 100 - last) {
            bw.write(last + "");
        } else {
            bw.write(sum + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
