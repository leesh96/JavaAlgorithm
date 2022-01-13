package baekjoon.simulation.silver4;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 1543
문제제목 : 문서 검색
난이도 : 실버 4
제한사항 : 2초/128MB
알고리즘 분류 : 문자열, 그리디 알고리즘, 브루트포스 알고리즘

알고리즘 설명
1. 문서의 앞에서부터 찾고자 하는 단어를 탐색
2. 만약 한번 등장하면 중복을 제거하기 위해 길이만큼 건너뛰어준다.

채점 결과 : 124ms/14240KB
풀이 날짜 : 2022/01/13
*/

public class B1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String delim = br.readLine();

        int count = 0;
        for (int i = 0; i < input.length() - delim.length() + 1; i++) {
            if (input.startsWith(delim, i)) {
                count++;
                i += delim.length() - 1;
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
