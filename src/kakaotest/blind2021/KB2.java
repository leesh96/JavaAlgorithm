package kakaotest.blind2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class KB2 {
    static HashMap<String, Integer> comb; // 단품 조합, 등장 횟수
    static int maxCount;

    public static void main(String[] args) {
        for (String s : solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4})) {
            System.out.println(s);
        };
    }

    static String[] solution(String[] orders, int[] course) {
        // 단품으로만 제공하던 메뉴를 조합해서 코스요리 형태로 재구성 -> 새로운 메뉴
        // 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성
        // 코스요리 메뉴는 최소 2가지 이상의 단품 메뉴로 구성
        // 최소 2명 이상의 손님으로부터 주문된 단품 메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함

        // 애초에 알파벳 순
        // 길이 별로 가장 많이 시킨 조합
        PriorityQueue<String> queue = new PriorityQueue<>();

        for (int i = 0; i < course.length; i++) {
            comb = new HashMap<>();
            maxCount = 0;
            for (int j = 0; j < orders.length; j++) {
                String curOrder = orders[j];
                if (curOrder.length() < course[i]) {
                    continue;
                }
                makeComb("", curOrder, course[i], 0, 0);
            }
            if (maxCount > 1) {
                for (String s : comb.keySet()) {
                    if (comb.get(s) == maxCount) {
                        queue.offer(s);
                    }
                }
            }
        }

        int idx = 0;
        String[] ans = new String[queue.size()];
        while (!queue.isEmpty()) {
            ans[idx++] = queue.poll();
        }

        return ans;
    }

    static void makeComb(String cur, String st, int depth, int curDepth, int prevIdx) {
        if (depth == curDepth) {
            char[] c = cur.toCharArray();
            Arrays.sort(c);
            StringBuilder res = new StringBuilder();
            for (char ch : c) {
                res.append(ch);
            }
            String com = res.toString();
            comb.put(com, comb.getOrDefault(com, 0) + 1);
            maxCount = Math.max(maxCount, comb.get(com));
            return;
        }

        for (int i = prevIdx; i < st.length(); i++) {
            char temp = st.charAt(i);
            makeComb(cur + temp, st, depth, curDepth + 1, i + 1);
        }
    }
}
