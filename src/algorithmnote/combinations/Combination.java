package algorithmnote.combinations;

import java.util.ArrayList;

public class Combination {
    // 조합 만들기 (n개의 숫자 중에서 r개를 뽑아서 만들 수 있는 조합)
    static int[] arr = { 1, 2, 3, 4 };
    static final int N = 4;
    static ArrayList<int[]> result;
    static int r;
    static boolean[] visit;

    public static void main(String[] args) {
        result = new ArrayList<>();
        visit = new boolean[N];
        r = 2;

        makeComb(new int[r], 0, 0);

        for (int[] l : result) {
            for (int n : l) {
                System.out.printf("%d ", n);
            }
            System.out.println();
        }
    }

    static void makeComb(int[] cur, int depth, int idx) {
        if (depth == r) {
            int[] temp = new int[r];
            int i = 0;
            for (int c : cur) {
                temp[i++] = c;
            }
            result.add(temp);
            return;
        }

        for (int i = idx; i < N; i++) {
            cur[depth] = arr[i];
            makeComb(cur, depth + 1, i + 1);
        }
    }
}
