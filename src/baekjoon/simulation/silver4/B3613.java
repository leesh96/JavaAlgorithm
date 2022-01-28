package baekjoon.simulation.silver4;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 3613
문제제목 : Java vs C++
난이도 : 실버 4
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 문자열, 많은 조건 분기, 파싱

알고리즘 설명
문자열 조건 확인
1. 첫 문자가 소문자가 아니면 에러
2. 현재 문자가 언더바 -> 자바 타입이면 에러, 마지막 문자가 언더바이면 에러, 언더바 연속이면 에러, 이외의 경우는 C 변수
3. 현재 문자가 대문자 -> C 타입이면 에러, 이외의 경우 자바 변수
4. 변수 타입에 알맞게 출력

채점 결과 : 124ms/14228KB
풀이 날짜 : 2022/01/28
*/

public class B3613 {
    enum Flag {
        ERROR, JAVA, CPLUS, INIT
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] input = br.readLine().toCharArray();
        Flag flag = Flag.INIT;
        if (!('a' <= input[0] && input[0] <= 'z')) {
            flag = Flag.ERROR;
        } else{
            for (int i = 1; i < input.length; i++) {
                char cur = input[i];
                if (cur == '_') {
                    if (flag == Flag.JAVA) {
                        flag = Flag.ERROR;
                        break;
                    } else {
                        if (i == input.length - 1) {
                            flag = Flag.ERROR;
                            break;
                        } else if (input[i+1] == '_') {
                            flag = Flag.ERROR;
                            break;
                        } else {
                            flag = Flag.CPLUS;
                        }
                    }
                } else if ('A' <= cur && cur <= 'Z') {
                    if (flag == Flag.CPLUS) {
                        flag = Flag.ERROR;
                        break;
                    } else {
                        flag = Flag.JAVA;
                    }
                }
            }
        }

        if (flag == Flag.ERROR) {
            bw.write("Error!");
        } else {
            StringBuilder sb = new StringBuilder();
            if (flag == Flag.JAVA) {
                for (int i = 0; i < input.length; i++) {
                    char cur = input[i];
                    if ('A' <= cur && cur <= 'Z') sb.append('_').append((char)(cur + 32));
                    else sb.append(cur);
                }
            } else {
                char prev = '0';
                for (int i = 0; i < input.length; i++) {
                    char cur = input[i];
                    if (prev == '_') {
                        sb.append((char)(cur - 32));
                    } else {
                        if (cur != '_') {
                            sb.append(cur);
                        }
                    }
                    prev = cur;
                }
            }
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
