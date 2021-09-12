package algorithmnote.combinations;

import java.util.ArrayList;

public class SubSet {
    // 부분집합 만들기
    static final int[] arr = { 1, 2, 3, 4 };
    static final int N = 4;
    static boolean[] used;
    static ArrayList<int[]> result;

    public static void main(String[] args) {
        result = new ArrayList<>();
        used = new boolean[N];
        result.add(new int[]{});
        makeSubSet(0);

        for (int[] l : result) {
            System.out.print("{ ");
            for (int n : l) {
                System.out.printf("%d ", n);
            }
            System.out.println("}");
        }
    }

    static void makeSubSet(int depth) {
        if (depth == N) {
            /*StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if (used[i]) {
                    sb.append(arr[i] + " ");
                }
            }
            result.add(sb.toString());*/
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (used[i]) count++;
            }
            if (count > 0) {
                int[] temp = new int[count];
                int idx = 0;
                for (int i = 0; i < N; i++) {
                    if (used[i]) {
                        temp[idx++] = arr[i];
                    }
                }
                result.add(temp);
            }
            return;
        }
        used[depth] = true;
        makeSubSet(depth + 1);
        used[depth] = false;
        makeSubSet(depth + 1);
    }
}
