import java.util.Scanner;

public class DSA_Prog7{
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            long result = countBSTs(n);
            System.out.println(result);
        }
        scanner.close();
    }

    private static long countBSTs(int n) {
        long[] dp = new long[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = (dp[i] + (dp[j - 1] * dp[i - j]) % MOD) % MOD;
            }
        }
        return dp[n];
    }
}

