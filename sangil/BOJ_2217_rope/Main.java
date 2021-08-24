package sangil.BOJ_2217_rope;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	
	static int N, maxWeight;
	static Integer[] ropes;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		maxWeight = 0;
		ropes = new Integer[N];
		
		for (int i = 0; i < N; i++) {
			ropes[i] = Integer.parseInt(br.readLine());
		}
		
		// 내림차순 정렬
		Arrays.sort(ropes, (i1, i2) -> i2-i1);
		// 로프 집합이 들 수 있는 최댓값은 가장 작은 로프의 무게가 결정한다.
		// 내림차순이므로 현재 로프는 항상 현재 로프를 포함한 집합의 가장 작은 로프이다.
		for (int i = 0; i < ropes.length; i++) {
			maxWeight = Math.max(maxWeight, ropes[i]*(i+1));
		}
		
		System.out.println(maxWeight);
	}
	
}
