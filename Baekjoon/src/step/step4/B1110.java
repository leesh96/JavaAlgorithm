package step.step4;

import java.io.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1110
 * 문제제목 : 더하기 사이클
 * 난이도 : 브론즈 1
 * 제한사항 : 2초/128MB
 * 알고리즘 분류 : 수학, 구현
 *
 * 채점 결과 : 148ms/15808KB
 * 풀이 날짜 : 2021/08/07
**/

public class B1110 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int count = 0;
        int newNumber = n;
        while (true) {
            count++;
            int sum = newNumber / 10 + newNumber % 10;
            newNumber = (newNumber % 10) * 10 + sum % 10;
            if (newNumber == n) {
                break;
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
