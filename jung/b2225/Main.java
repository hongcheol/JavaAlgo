package b2225;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		long[][] arr = new long[K+1][N+1];
		for (int i = 1; i <= K; i++) {
			arr[i][0] = 1;
		}
		for (int i = 1; i <= N; i++) {
			arr[1][i] = 1;
		}

		for (int i = 2; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = (arr[i-1][j] + arr[i][j-1])%1000000000;
			}
		}
//		for (int i = 0; i <K+1; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		System.out.println(arr[K][N]);
	}

}
