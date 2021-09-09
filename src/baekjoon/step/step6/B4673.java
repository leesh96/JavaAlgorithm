package baekjoon.step.step6;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class B4673 {
    static boolean[] arr;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = new boolean[10001];
        for (int i = 1; i <= 10000; i++) {
            int temp = d(i);
            if (temp < 10001) {
                arr[d(i)] = true;
            }
        }
        for (int i = 1; i <= 10000; i++) {
            if (!arr[i]) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static int d(int n) {
        int sum = n;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
