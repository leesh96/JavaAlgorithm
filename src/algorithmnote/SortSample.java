package algorithmnote;

import java.io.*;
import java.util.StringTokenizer;

public class SortSample {
    // 퀵 정렬, 병합 정렬 -> 정렬 라이브러리 쓰는게 에러 안나서 좋음.. 조건이 특이한 경우에만 직접 구현
    static int[] arr, first, sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        first = new int[n];
        sorted = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void quickSort(int start, int end) {
        if (start > end) {
            return;
        }

        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && arr[left] < arr[pivot]) {
                left++;
            }
            while (right > start && arr[right] >= arr[pivot]) {
                right--;
            }
            if (left > right) {
                int temp = arr[right];
                arr[right] = arr[pivot];
                arr[pivot] = temp;
            } else {
                int temp = arr[left];
                arr[left] = arr[pivot];
                arr[pivot] = temp;
            }
        }

        quickSort(start, right - 1);
        quickSort(right + 1, end);
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
            if (arr[i] <= arr[j])  {
                sorted[k++] = arr[i++];
            } else {
                sorted[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            sorted[k++] = arr[i++];
        }

        while (j <= end) {
            sorted[k++] = arr[j++];
        }

        i = start;
        k = 0;
        while (i <= end) {
            arr[i++] = sorted[k++];
        }
    }
}
