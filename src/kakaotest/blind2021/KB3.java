package kakaotest.blind2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class KB3 {
    static HashMap<String, ArrayList<Integer>> group;

    public static void main(String[] args) {
        for (int n : solution(new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"}, new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"})) {
            System.out.printf("%d ", n);
        }
        System.out.println();
    }

    static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        group = new HashMap<>();
        for (int i = 0; i < info.length; i++) {
            String[] vol = info[i].split(" ");
            makeComb(vol, "", 0);
        }
        for (String s : group.keySet()) {
            Collections.sort(group.get(s));
        }
        for (int i = 0; i < query.length; i++) {
            String q = query[i];
            q = q.replaceAll(" and ", "");
            String[] st = q.split(" ");
            int score = Integer.parseInt(st[1]);

            answer[i] = lowerBound(st[0], score);
        }

        return answer;
    }

    static void makeComb(String[] vol, String cur, int depth) {
        if (depth == 4) {
            if (!group.containsKey(cur)) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(Integer.parseInt(vol[4]));
                group.put(cur, temp);
            } else {
                group.get(cur).add(Integer.parseInt(vol[4]));
            }
            return;
        }

        makeComb(vol, cur + "-", depth + 1);
        makeComb(vol, cur + vol[depth], depth + 1);
    }

    static int lowerBound(String query, int target) {
        if (!group.containsKey(query)) {
            return 0;
        }

        ArrayList<Integer> list = group.get(query);
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return list.size() - start;
    }
}
