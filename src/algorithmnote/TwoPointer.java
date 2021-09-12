package algorithmnote;

public class TwoPointer {
    // 느낌만 알고 가기. 합이 x 이상인 부분수열의 최소 길이 찾기
    // 시작, 끝 포인터 둘 다 처음위치인 경우, 시작 포인터는 처음, 끝 포인터는 배열 마지막인 경우가 존재
    static int[] numbers = {2, 4, 11, 3, 7};

    public static void main(String[] args) {

    }

    static int solution(int target) {
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        int start = 0, end = 0;

        while (true) {
            if (sum >= target) {
                sum -= numbers[start];
                int temp = end - start;
                if (temp < answer) {
                    answer = temp;
                }
                start++;
            } else if (end == numbers.length) {
                break;
            } else {
                sum += numbers[end];
                end++;
            }
        }

        return answer;
    }
}
