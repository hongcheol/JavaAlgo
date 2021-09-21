package sangil.BOJ_2156_wine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		// n이 1이 들어와도 2까지는 만든다.
		int[] wines = new int[N+2];
		int[] drinks = new int[N+2];
		
		for (int i = 1; i <= N; i++) {
			wines[i] = Integer.parseInt(br.readLine());
		}
		
		// 3부터 순회할 것이므로 1과 2일때 값을 넣어놓는다.
		drinks[1] = wines[1];
		drinks[2] = wines[1] + wines[2];
		
		for (int i = 3; i <= N; i++) {
			// 0번 연속(현재 와인 선택 x) : drinks[i-1]
			// 1번 연속(직전 와인 선택 x) : drinks[i-2]+wines[i]
			// 2번 연속(두번째 전 와인 선택x) : drinks[i-3]+wines[i-1]+wines[i]
			// 중에서 큰 값을 넣는다.
			drinks[i] = Math.max(drinks[i-1], Math.max(drinks[i-2]+wines[i], drinks[i-3]+wines[i-1]+wines[i])); 
		}
		
		System.out.println(drinks[N]);
	}
	
	
}
