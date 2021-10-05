package b11054;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N + 2];
		int[] LIS = new int[N + 2];
		int[] LDS = new int[N + 2];

		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			int n = 0;
			for (int j = i-1; j >=0; j--) {
				if(arr[j]<arr[i]) {
					LIS[i] = Math.max(LIS[j]+1, LIS[i]);
				}
			}
			
		}

		
		for (int i = N; i >= 1; i--) {
			int n = 0;
			for (int j = i+1; j <=N+1; j++) {
				if(arr[j]<arr[i]) {
					LDS[i] = Math.max(LDS[j]+1, LDS[i]);
				}
			}
		}
		for (int i = 1; i <=N; i++) {
			max = Math.max(max, LIS[i]+LDS[i]);
		}
		System.out.println(max-1);

	}

}
