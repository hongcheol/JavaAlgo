package sangil.BOJ_2225_sum_decomposition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static final int MOD = 1000000000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] cnt = new int[K+1][N+1];
		for (int k = 1; k <= K; k++) {
			for (int n = 0; n <= N; n++) {
				// 1개로 만드는 방법은 1개이다.
				if(k==1) cnt[k][n] = 1;
				// k-1개로 n-i를 만들었을 때, i를 더하면 n이 된다.
				// 순서가 상관없으로므로 n-i에 i를 더하는 경우의 수는 k-1개로 n-i를 만든 경우의 수와 같다.
				for (int i = 0; i <= n; i++) {
					cnt[k][n] += cnt[k-1][n-i];
					cnt[k][n] %= MOD;
				}
			}
		}
		
		System.out.println(cnt[K][N]);
	}
	
}
