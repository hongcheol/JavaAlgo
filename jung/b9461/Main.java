package b9461;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			long[] arr = new long[101];
			arr[1] = arr[2] = arr[3] = 1;
			arr[4] = arr[5] = 2;
			
			for (int i = 6; i <= N; i++) {
				arr[i] = arr[i-2] + arr[i-3];
			}
			
			System.out.println(arr[N]);
		}
		
	}

}
