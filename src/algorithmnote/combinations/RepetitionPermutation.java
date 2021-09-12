package algorithmnote.combinations;

import java.util.ArrayList;

public class RepetitionPermutation {
    // 중복순열 만들기
    static int[] arr = { 1, 2, 3, 4 };
    static final int N = 4;
    static ArrayList<int[]> result;
    static int r;
    static boolean[] visit;

    public static void main(String[] args) {
        result = new ArrayList<>();
        visit = new boolean[N];
        r = 2;

        makeRPerm(new int[r], 0);

        for (int[] l : result) {
            for (int n : l) {
                System.out.printf("%d ", n);
            }
            System.out.println();
        }
    }

    static void makeRPerm(int[] cur, int depth) {
        if (depth == r) {
            int[] temp = new int[r];
            int idx = 0;
            for (int c : cur) {
                temp[idx++] = c;
            }
            result.add(temp);
            return;
        }

        for (int i = 0; i < N; i++) {
            cur[depth] = arr[i];
            makeRPerm(cur, depth + 1);
        }
    }
}
