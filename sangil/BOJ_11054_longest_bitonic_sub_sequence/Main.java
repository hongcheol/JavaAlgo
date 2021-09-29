package sangil.BOJ_11054_longest_bitonic_sub_sequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		int[] lis = new int[n];
		int[] lds = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// lis
		for (int i = 0; i < n; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				// 현재 값이 nums[i], 비교 대상이 nums[j]
				if(nums[i] > nums[j]) {
					// j포함 해서 길어질 수 있다. j는 3까지, i는 j+1
					lis[i] = Math.max(lis[i], lis[j]+1);
				}
			}
		}
		
		// lds
		// 오른쪽에서 왼쪽으로 lis를 만들면 내림차순과 같은 효과이다.
		for (int i = n-1; i >= 0; i--) {
			lds[i] = 1;
			for (int j = n-1; j >= i; j--) {
				if(nums[i] > nums[j]) {
					lds[i] = Math.max(lds[i], lds[j]+1);
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, lis[i] + lds[i] - 1);
		}
		
		System.out.println(max);
	}

}
