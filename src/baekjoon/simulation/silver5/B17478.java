package baekjoon.simulation.silver5;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 17478
문제제목 : 재귀함수가 뭔가요?
난이도 : 실버 5
제한사항 : 1초/256MB
알고리즘 분류 : 구현, 재귀

알고리즘 설명
1. 재귀함수 구현

채점 결과 : 144ms/14464KB
풀이 날짜 : 2021/12/31
*/

public class B17478 {
    static String underLine = "";
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");

        print(n);

        bw.flush();
        bw.close();
        br.close();
    }

    static void print(int n) throws IOException {
        String prefix = underLine;

        if (n == 0) {
            bw.write(prefix + "\"재귀함수가 뭔가요?\"\n");
            bw.write(prefix + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            bw.write(prefix + "라고 답변하였지.\n");
            return;
        }

        bw.write(prefix + "\"재귀함수가 뭔가요?\"\n");
        bw.write(prefix + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
        bw.write(prefix + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
        bw.write(prefix + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");

        underLine += "____";

        print(n-1);

        bw.write(prefix + "라고 답변하였지.\n");
    }
}
