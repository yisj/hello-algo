import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[100_001];
		
		for(int i=0; i<=100_000; i++)
			dp[i] = -1;
		
		
		dp[2] = 1;
		dp[5] = 1;
		
		for(int i=0; i<=n; i++) {
			if(i>=5 && dp[i-2] != -1 && dp[i-5] != -1) {
				dp[i] = Math.min(dp[i-2]+1, dp[i-5]+1);
			} else if(i>=2 && dp[i-2] != -1) {
				dp[i] = dp[i-2]+1;
			} else if(i>=5 && dp[i-5] != -1) {
				dp[i] = dp[i-5]+1;
			}
		}
		System.out.println(dp[n]);
	}
}