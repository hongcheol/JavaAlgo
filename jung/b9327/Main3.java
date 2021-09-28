package b9327;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
	static int IMPOSSINLE = 400001;
	static int N, E;
	static int[] arr;
	static int[] sum;
	static int min;
	static int[] dp;
	static ArrayList<int[]> a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			N = sc.nextInt();
			E = sc.nextInt();
			arr = new int[N + 1];
			sum = new int[N + 1];
			a= new ArrayList<int[]>();
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
				dp = new int[N + 1];
				int min = 20001;
				dp[0] = -E;

				a.add(new int[] { 1, -E });
				int i=0;
				while (i<a.size()) {
					int[] m = a.get(i);
					System.out.println(Arrays.toString(m));
					if (m[0] < N) {
						if (m[1] + arr[m[0]]*2 >= 0) {
							min = Math.min(min, m[1] + arr[m[0]]*2);
						} else {
							a.add(new int[] { m[0]+1, m[1] + arr[m[0]]*2 });
						}
						if(sum[m[0]+1]*2+m[1] >=0 && sum[m[0]+1]*2+m[1] < min)
							a.add(new int[] { m[0]+1, m[1] });
					}
					i++;
				}
				System.out.println((E + min) / 2);

			}
		}
	}

}
