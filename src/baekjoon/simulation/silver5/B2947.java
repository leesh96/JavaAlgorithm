package baekjoon.simulation.silver5;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2947
문제제목 : 나무 조각
난이도 : 실버 5
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 시뮬레이션

알고리즘 설명
1. 배열의 뒤와 비교하면서 교체 수행
2. 교체 했다면 print
3. 한번도 교체가 일어나지 않았다면 정렬된 순서이므로 종료

채점 결과 : 148ms/14552KB
풀이 날짜 : 2021/11/12
*/

public class B2947 {
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[5];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            boolean flag = false;

            for (int i = 0; i < 4; i++) {
                if (arr[i] > arr[i+1]) {
                    flag = true;
                    int temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                    print();
                }
            }

            if (!flag) {
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void print() throws IOException {
        for (int i = 0; i < 5; i++) {
            bw.write(arr[i] + " ");
        }
        bw.newLine();
    }
}
