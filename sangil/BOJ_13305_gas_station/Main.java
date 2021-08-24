package sangil.BOJ_13305_gas_station;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static long minSum;
	static int[] distances, prices;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		distances = new int[N-1];
		prices = new int[N];
		minSum = 0L;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N-1; i++) {
			distances[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			prices[i] = Integer.parseInt(st.nextToken());
		}
		
		// cur: 현재 주요소, i: 다음 주유소
		for (int i = 1, cur = 0; i < N; i++) {
			// 현재 주유소에서 다음 주유소에 갈 수 있을 만큼만 넣는다.
			minSum += (long) prices[cur] * distances[i-1];
			// 현재 주유소보다 다음 주유소가 더 싸다면 다음 주유소로 이동한다.
			if(prices[cur] > prices[i]) {
				cur = i;
			}
		}
		
		System.out.println(minSum);
	}
	
}
