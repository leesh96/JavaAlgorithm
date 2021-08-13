package bojclass.class2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 11651
 * 문제제목 : 좌표 정렬하기 2
 * 난이도 : 실버 5
 * 제한사항 : 1초/256MB
 * 알고리즘 분류 : 정렬
 *
 * 알고리즘 설명
 * 병합정렬 구현
 *
 * 채점 결과 : 776ms/54180KB
 * 풀이 날짜 : 2021/07/22
**/

public class B11651 {
    static int n;
    static point[] arr, sort;

    static class point {
        int x, y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new point[n];
        sort = new point[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        mergeSort(0, n - 1);
        for (point p : sort) {
            bw.write(p.x + " " + p.y + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, end, mid);
        }
    }

    static void merge(int start, int end, int mid) {
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (arr[i].y < arr[j].y) {
                sort[k++] = arr[i++];
            } else if (arr[i].y > arr[j].y) {
                sort[k++] = arr[j++];
            } else {
                if (arr[i].x < arr[j].x) {
                    sort[k++] = arr[i++];
                } else {
                    sort[k++] = arr[j++];
                }
            }
        }

        while (i <= mid) {
            sort[k++] = arr[i++];
        }

        while (j <= end) {
            sort[k++] = arr[j++];
        }

        i = start; k = 0;
        while (i <= end) {
            arr[i++] = sort[k++];
        }
    }
}
