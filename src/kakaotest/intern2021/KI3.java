package kakaotest.intern2021;

import java.util.Stack;

public class KI3 {
    public static void main(String[] args) {
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        System.out.println(solution(8, 2, cmd));
    }

    static String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
        int[] segTree = new int[n * 4];
        Stack<Integer> last = new Stack<>();
        int curIdx = k;
        init(segTree, 0, n - 1, 1);
        for (int i = 0; i < cmd.length; i++) {
            String[] order = cmd[i].split(" ");
            if (order[0].equals("U")) {
                int x = Integer.parseInt(order[1]) + 1;
                int start = 0;
                int end = curIdx - 1;

                while (start <= end) {
                    int mid = (start + end) / 2;
                    int sectSum = sum(segTree, 0, n - 1, mid, curIdx,1);

                    if (sectSum < x) {
                        end = mid - 1;
                    } else if (sectSum > x) {
                        start = mid + 1;
                    } else {
                        curIdx = mid;
                        while (sum(segTree, 0, n - 1, curIdx, curIdx, 1) != 1) {
                            curIdx++;
                        }
                        break;
                    }
                }
            } else if (order[0].equals("D")) {
                int x = Integer.parseInt(order[1]) + 1;
                int start = curIdx + 1;
                int end = n - 1;

                while (start <= end) {
                    int mid = (start + end) / 2;
                    int sectSum = sum(segTree, 0, n - 1, curIdx, mid, 1);

                    if (sectSum < x) {
                        start = mid + 1;
                    } else if (sectSum > x){
                        end = mid - 1;
                    } else {
                        curIdx = mid;
                        while (sum(segTree, 0, n - 1, curIdx, curIdx, 1) != 1) {
                            curIdx--;
                        }
                        break;
                    }
                }
            } else if (order[0].equals("C")) {
                update(segTree, 0, n - 1, 1, curIdx, 0);
                last.push(curIdx);
                int start = curIdx + 1;
                int end = n - 1;
                boolean isDownSide = false;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    int sectSum = sum(segTree, 0, n - 1, curIdx, mid, 1);

                    if (sectSum < 1) {
                        start = mid + 1;
                    } else if (sectSum > 1) {
                        end = mid - 1;
                    } else {
                        isDownSide = true;
                        curIdx = mid;
                        while (sum(segTree, 0, n - 1, curIdx, curIdx, 1) != 1) {
                            curIdx--;
                        }
                        break;
                    }
                }
                if (!isDownSide) {
                    start = 0;
                    end = curIdx - 1;
                    while (start <= end) {
                        int mid = (start + end) / 2;
                        int sectSum = sum(segTree, 0, n - 1, mid, curIdx, 1);

                        if (sectSum < 1) {
                            end = mid - 1;
                        } else if (sectSum > 1) {
                            start = mid + 1;
                        } else {
                            curIdx = mid;
                            while (sum(segTree, 0, n - 1, curIdx, curIdx, 1) != 1) {
                                curIdx++;
                            }
                            break;
                        }
                    }
                }
            } else if (order[0].equals("Z")) {
                update(segTree, 0, n - 1, 1, last.pop(), 1);
            }
        }

        for (int i = 0; i < n; i++) {
            int sum = sum(segTree, 0, n - 1, i, i, 1);
            if (sum == 0) {
                answer.append("X");
            } else if (sum == 1) {
                answer.append("O");
            }
        }

        return answer.toString();
    }

    static int init(int[] segTree, int start, int end, int idx) {
        if (start == end) {
            return segTree[idx] = 1;
        } else {
            int mid = (start + end) / 2;
            return segTree[idx] = init(segTree, start, mid, idx * 2) + init(segTree, mid + 1, end, idx * 2 + 1);
        }
    }

    static int sum(int[] segTree, int start, int end, int left, int right, int idx) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && end <= right) {
            return segTree[idx];
        }

        int mid = (start + end) / 2;
        return sum(segTree, start, mid, left, right, idx * 2) + sum(segTree, mid + 1, end, left, right, idx * 2 + 1);
    }

    static int update(int[] segTree, int start, int end, int idx, int target, int value) {
        if (target < start || target > end) {
            return segTree[idx];
        }

        if (start == end) {
            return segTree[idx] = value;
        }

        int mid = (start + end) / 2;
        return segTree[idx] = update(segTree, start, mid, idx * 2, target, value) + update(segTree, mid + 1, end, idx * 2 + 1, target, value);
    }
}
