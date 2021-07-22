package class2;

import java.io.*;
import java.util.Arrays;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1181
 * 문제제목 : 단어 정렬
 * 난이도 : 실버 5
 * 제한사항 : 2초/256MB
 * 알고리즘 분류 : 정렬
 *
 * 알고리즘 설명
 * 1. Comparable 구현 또는 mergeSort 직접 구현
 *
 * 채점 결과 : 356ms/30604KB(mergeSort), 308ms/31264KB(Comparable 구현)
 * 풀이 날짜 : 2021/07/17
**/

public class B1181 {
    static int n;
    static word[] arr, sort;

    static class word { //implements Comparable<word>{
        int length;
        String name;

        public word(String n) {
            this.length = n.length();
            this.name = n;
        }
//
//        @Override
//        public int compareTo(word o) {
//            if (this.length == o.length) {
//                return this.name.compareTo(o.name);
//            } else {
//                return this.length - o.length;
//            }
//        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new word[n];
        sort = new word[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new word(br.readLine());
        }

        mergeSort(0, n - 1);
        Arrays.sort(arr);

        bw.write(arr[0].name + "\n");
        for (int i = 1; i < n; i++) {
            if (arr[i].name.compareTo(arr[i-1].name) != 0) {
                bw.write(arr[i].name + "\n");
            }
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
            merge(start, mid, end);
        }
    }

    static void merge(int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = start;

        while (i <= mid && j <= end) {
            if (arr[i].length < arr[j].length) {
                sort[k++] = arr[i++];
            } else if (arr[i].length > arr[j].length) {
                sort[k++] = arr[j++];
            } else {
                if (arr[i].name.compareTo(arr[j].name) < 0) {
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

        for (k = start; k <= end; k++) {
            arr[k] = sort[k];
        }
    }
}
