package sangil.BOJ_1806_subtotal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		int result = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int lo = 0, hi = 0;
		int subtotal = nums[hi];
		loop:
		while(lo < N) {	
			//현재 부분합이 목표보다 클 때, 현재 범위 값이 기존 보다 작으면 갱신한다. 
			//탐색을 이어가기 위해 왼쪽 포인터를 올린다.
			if(subtotal >= S) {
				result = Math.min(result, hi-lo+1);
				if(result == 1) break loop;
				subtotal -= nums[lo++];
			//현재 부분합이 목표보다 작을 때 오른쪽 포인터를 올려서 그 값을 더해준다.
			}else {
				if(hi == N-1) break loop;
				subtotal += nums[++hi];
			}
		
		}
		
		result = (result==Integer.MAX_VALUE)? 0: result;
		
		System.out.println(result);
	}

}
