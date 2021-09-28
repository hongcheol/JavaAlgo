package b1912;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		Arrays.fill(dp, -1001);
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		int max = -1001;
		for (int i = 1; i <= N; i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}

}
