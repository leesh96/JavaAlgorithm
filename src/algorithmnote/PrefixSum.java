package algorithmnote;

public class PrefixSum {
    // 누적합 구하기
    static int[] prefixSum;
    static int[] nums;

    public static void main(String[] args) {
        nums = new int[] {3, 9, 20, 4, 1};

        prefixSum = new int[5];
        prefixSum[0] = nums[0];
        for (int i = 1; i < 5; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        // 인덱스 i부터 j까지의 구간합을 구하는 경우 (i가 0인 경우 prefixSum[j])
        int i = 1;
        int j = 3;
        int oneToThree = prefixSum[j] - prefixSum[i-1];
    }
}
