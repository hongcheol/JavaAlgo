package sangil.BOJ_1912_continuous_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] sums = new int[N];
		sums[0] = nums[0];
		int max = sums[0];
		for (int i = 1; i < N; i++) {
			sums[i] = Math.max(sums[i-1] + nums[i], nums[i]);
			max = Math.max(sums[i], max);
		}
		
		System.out.println(Arrays.toString(sums));
		System.out.println(max);
		
	}

}
