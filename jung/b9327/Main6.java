package b9327;

import java.util.Arrays;
import java.util.Scanner;

public class Main6 {
	static int IMPOSSINLE = 400001;
	static int N, E;
	static int[] arr;
	static int[] sum;
	static int min;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			N = sc.nextInt();
			E = sc.nextInt();
			arr = new int[N + 1];
			sum = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				arr[i] = sc.nextInt();
			}
			sum[N] = arr[N];
			for (int i = N - 1; i > 0; i--) {
				sum[i] = sum[i + 1] + arr[i];
			}
			if (sum[1] * 2 < E) {
				System.out.println("FULL");
			} else if (sum[1] * 2 == E) {
				System.out.println(sum);

			} else if (E == 0) {
				System.out.println("0");
			} else {
				dp = new int[N + 1][E + 1];

				Arrays.fill(dp[0], IMPOSSINLE);
				for (int i = 1; i <= N; i++) {
					for (int j = 0; j <= E; j++) {
						if (arr[i] * 2 >= j) {
							dp[i][j] = Math.min(dp[i - 1][j], arr[i] * 2 - j);
						} else {
							dp[i][j] = Math.min(dp[i - 1][j - arr[i] * 2], dp[i - 1][j]);
						}
					}

				}
				System.out.println((dp[N][E] + E) / 2);

				for (int i = 0; i <= N; i++) {
					for (int j = 0; j <= E; j += 100) {
						System.out.print((dp[i][j] + "\t"));
					}
					System.out.println();
				}

			}
		}
	}

}
