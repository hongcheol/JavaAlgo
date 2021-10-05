package b2156;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		int N = sc.nextInt();
		int [] arr = new int[N+1];
		int[] wine = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		
		wine[1] = arr[1];
		if (N > 1) {
			wine[2] = arr[1] + arr[2];
		}
		for (int i = 3; i <= N; i++) {
			wine[i] = Math.max(wine[i - 1], Math.max(wine[i - 2] + arr[i], wine[i - 3] + arr[i - 1] + arr[i]));
 
		}
		System.out.println(wine[N]);
		
		
	}

}
