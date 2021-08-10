package sangil.BOJ_10989_sort_number3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[10001];
		
		for (int i = 0; i < N; i++) {
			nums[Integer.parseInt(br.readLine())]++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < nums[i]; j++) {
				sb.append(i).append("\n");				
			}	
		}
		
		//단순 정렬
//		for(int i = 0; i < N; i++) {
//			nums[i] = Integer.parseInt(br.readLine());
//		}			
//		
//		Arrays.sort(nums);
//
//		StringBuilder sb = new StringBuilder();
//		for (int i : nums) {
//			sb.append(i).append("\n");
//		}
		System.out.println(sb);
	}	
	
}

