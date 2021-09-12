package algorithmnote;

import java.io.*;
import java.util.StringTokenizer;

public class RotateArray {
    // 배열 회전 (+90도)
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println("start");
        printArray();
        System.out.println();

        for (int i = 1; i < 5; i++) {
            System.out.printf("# %d degree\n", 90 * i);
            arr = rotateArray();
            printArray();
            System.out.println();
        }

        br.close();
    }

    static int[][] rotateArray() {
        int rowLength = arr.length;
        int colLength = arr[0].length;
        int[][] result = new int[colLength][rowLength];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                result[j][rowLength - 1 - i] = arr[i][j];
            }
        }

        return result;
    }

    static int[][] rotateSquareArray() {
        int n = arr.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][n - 1 - i] = arr[i][j];
            }
        }

        return result;
    }

    static void printArray() {
        for (int[] row : arr) {
            for (int n : row) {
                System.out.printf("%d ", n);
            }
            System.out.println();
        }
    }
}
