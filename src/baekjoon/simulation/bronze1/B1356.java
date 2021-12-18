package baekjoon.simulation.bronze1;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 1356
문제제목 : 유진수
난이도 : 브론즈 1
제한사항 : 2초/128MB
알고리즘 분류 : 수학, 구현, 문자열, 사칙연산

알고리즘 설명
1. 입력받은 숫자를 각 자리수로 분리해서 배열에 담아놓고
2. 좌 우로 누적합을 구해놓는다. (배열 두개에)
3. 0 ~ size-1 까지 i와 i+1 자리의 누적합을 비교한다.
4. 같으면 유진수 다르면 NO

채점 결과 : 124ms/14256KB
풀이 날짜 : 2021/12/18
*/

public class B1356 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        int size = input.length();
        int[] n = new int[size];
        for (int i = 0; i < size; i++) {
            n[i] = input.charAt(i) - '0';
        }

        int[] startPrefix = new int[size];
        int[] endPrefix = new int[size];
        startPrefix[0] = n[0];
        endPrefix[size-1] = n[size-1];
        for (int i = 1; i < size; i++) {
            startPrefix[i] = startPrefix[i-1] * n[i];
            endPrefix[size-1-i] = endPrefix[size-i] * n[size-1-i];
        }

        boolean flag = false;
        for (int i = 0; i < size - 1; i++) {
            if (startPrefix[i] == endPrefix[i+1]) {
                flag = true;
                break;
            }
        }

        if (flag) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
