package b9327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N, E;
	static int[] arr;
	static int[] sum;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			arr = new int[N];
			sum = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			sum[N - 1] = arr[N - 1];
			for (int i = N - 2; i >= 0; i--) {
				sum[i] = sum[i + 1] + arr[i];
			}

			min = Integer.MAX_VALUE;
			if (sum[0] < E / 2) {
				System.out.println("FULL");
			} else if (sum[0] * 2 == E) {
				System.out.println(sum);

			} else if (E == 0) {
				System.out.println(0);
			} else {
				meomory(0, 0);

				System.out.println(min);
			}
		}
	}

	private static void meomory(int n, int me) {
		
		if (me * 2 >= E) {
			min = Math.min(min, me);
			return;
		}
		if(n==N) {
			return;
		}
		if ((sum[n]+me )* 2 < E) {
			return;
		}
		if (n < N) {
			meomory(n + 1, me);
			if (min > me +arr[n])
				meomory(n + 1, me + arr[n]);
		}
	}

}
