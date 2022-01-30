package baekjoon.steps.step7;

import java.io.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 2941
 * 문제제목 : 크로아티아 알파벳
 * 난이도 : 실버 5
 * 제한사항 : 1초/128MB
 * 알고리즘 분류 : 구현, 문자열
 *
 * 알고리즘 설명
 * 조건에 맞게 문자열 인덱스 조작
 *
 * 채점 결과 : 160ms/15728KB
 * 풀이 날짜 : 2021/08/08
**/

public class B2941 {
    static char[] word;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        word = br.readLine().trim().toCharArray();
        int count = 0;
        for (int i = 0; i < word.length; i++) {
            if (word[i] == 'c') {
                if (i < word.length - 1 && (word[i+1] == '-' || word[i+1] == '=')) {
                    i++;
                }
            } else if (word[i] == 'd') {
                if (i < word.length - 2 && (word[i+1] == 'z' && word[i+2] == '=')) {
                    i += 2;
                } else if (i < word.length - 1 && word[i+1] == '-') {
                    i++;
                }
            } else if (word[i] == 'l' || word[i] == 'n') {
                if (i < word.length - 1 && word[i+1] == 'j') {
                    i++;
                }
            } else if (word[i] == 's' || word[i] == 'z') {
                if (i < word.length - 1 && word[i+1] == '=') {
                    i++;
                }
            }
            count++;
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
