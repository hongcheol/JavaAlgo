package b9327;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
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
			arr = new int[N];
			sum = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			sum[N-1] = arr[N-1];
			for (int i = N-2; i >=0; i--) {
				sum[i] = sum[i+1]+arr[i];
			}
			if (sum[0]*2 < E) {
				System.out.println("FULL");
			} else if(sum[0]*2 == E){
				System.out.println(sum[0]);
				
			}else if (E == 0) {
				System.out.println("0");
			} else {
				dp = new int[N][E+1];
				for (int i = 0; i < N; i++) {
					Arrays.fill(dp[i], -1);
				}

				System.out.println((E+memory(0, E))/2);

			}
		}
	}

	private static int memory(int n, int me) {
		if(n==N) {
			return IMPOSSINLE;
		}
		if (dp[n][me] != -1) {
			return dp[n][me];
		}
		if(sum[n]*2 < me) return dp[n][me]=IMPOSSINLE;
		
		dp[n][me] = memory(n+1,me);
		if(arr[n]*2 >= me ) {

			dp[n][me] = Math.min(dp[n][me],arr[n]*2-me);
		}
		
		else {

			dp[n][me] = Math.min(dp[n][me], memory(n+1, me-arr[n]*2));
		}
		
		return dp[n][me];
	}

}
