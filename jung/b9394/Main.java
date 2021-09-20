package b9394;

import java.util.Scanner;

public class Main {

	
	// 피보나치 문제
	// n 번째가 악수를 하는경우 dp[n-2]
	// n 번째가 악수를 하지 않는경우 dp[n-1]
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		arr[0] = 1;
		arr[1] = 1;
		for (int i = 2; i <= N; i++) {		// 일의 자리만
			arr[i] = arr[i-1]%10 + arr[i-2]%10;
		}
		
		System.out.println(arr[N]%10);
	}

}
