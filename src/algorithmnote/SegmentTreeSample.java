package algorithmnote;

public class SegmentTreeSample {
    static int[] arr, segTree;
    static int n, segN;

    public static void main(String[] args) {
        n = 8;

        arr = new int[] { 2, 5, 7, 4, 3, 1, 5, 6};

        // 세그먼트 트리의 크기 구하기

        /*정석 방식
        for (segN = 1; segN < n; segN *= 2);
        segTree = new int[(int)(1 * Math.pow(2, (int)Math.ceil(Math.log10(segN) / Math.log10(2)) + 1))];*/

        // 4 * n 방식 (공간에 여유있음)
        segTree = new int[4 * n];
        create(0, n - 1, 1);
    }

    // 세그먼트 트리 생성
    static int create(int start, int end, int idx) {
        if (start == end) {
            return segTree[idx] = arr[start];
        }
        int mid = (start + end) / 2;
        return segTree[idx] = create(start, mid, idx * 2) + create(mid + 1, end, idx * 2 + 1);
    }

    // 세그먼트 트리 값 변경 (기존 값과 새로운 값의 차이 사용)
    static void updateWithDiff(int start, int end, int idx, int target, int diff) {
        if (target < start || target > end) {
            return;
        }

        segTree[idx] += diff;

        if (start == end) {
            arr[target] = segTree[idx];
            return;
        }

        int mid = (start + end) / 2;
        updateWithDiff(start, mid, idx * 2, target, diff);
        updateWithDiff(mid + 1, end, idx * 2 + 1, target, diff);
    }

    // 세그먼트 트리 값 변경 (기존 값을 새로운 값으로 대치)
    static int updateWithValue(int start, int end, int idx, int target, int value) {
        if (target < start || target > end) {
            return segTree[idx];
        }

        if (start == end) {
            return segTree[idx] = value;
        }

        int mid = (start + end) / 2;
        return segTree[idx] = updateWithValue(start, mid, idx * 2, target, value) + updateWithValue(mid + 1, end, idx * 2 + 1, target, value);
    }

    // 세그먼트 트리 구간 합 구하기
    static int sum(int start, int end, int left, int right, int idx) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && end <= right) {
            return segTree[idx];
        }

        int mid = (start + end) / 2;
        return sum(start, mid, left, right, idx * 2) + sum(mid + 1, end, left, right, idx * 2 + 1);
    }
}
