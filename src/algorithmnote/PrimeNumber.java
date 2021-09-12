package algorithmnote;

public class PrimeNumber {
    // 에라토스테네스의 채 소수 판별
    static boolean[] isPrime;

    public static void main(String[] args) {
        int n = 100000;
        isPrime = new boolean[n+1];

        for (int i = 2; i < (int) Math.sqrt(n) + 1; i++) {
            if (!isPrime[i]) {
                for (int j = i + i; j <= n; j++) {
                    isPrime[j] = true;
                }
            }
        }
    }
}
