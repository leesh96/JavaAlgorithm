package algorithmnote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindBound {
    // Binary Search, Lower Bound, Upper Bound
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        while (true) {
            int target = Integer.parseInt(br.readLine());

            if (target < 0) {
                br.close();
                System.exit(0);
            }

            int lowerBound = lowerBound(target);
            int upperBound = upperBound(target);

            System.out.printf("lowerBound : %d, upperBound : %d\n", lowerBound, upperBound);
            // upperBound - lowerBound 하면 배열 내의 그 숫자의 갯수
        }
    }

    static int upperBound(int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

    static int lowerBound(int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

    static int binarySearch(int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
