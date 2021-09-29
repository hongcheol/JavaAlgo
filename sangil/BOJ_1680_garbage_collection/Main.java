package sangil.BOJ_1680_garbage_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int[] xs = new int[N];
			int[] ws = new int[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				xs[i] = Integer.parseInt(st.nextToken());
				ws[i] = Integer.parseInt(st.nextToken());
			}
			
			int curW = 0;
			int distance = 0;
			boolean flag = true;
			for(int i = 0; i < N; i++) {
				// 쓰레기장에서 새로 도착
				if(flag) {
					distance += xs[i];
					flag = false;
				} else {
					// 이전 지점 이어서 도착
					distance += (xs[i] - xs[i-1]);
					
					// 현재 지점에서 실을 수 없을 때
					if(curW + ws[i] > W) {
						// 쓰레기장 왕복
						distance += xs[i] * 2;
						curW = 0;
					} 
				}
				// 현재 지점에서 실음
				curW += ws[i];					
				
				// 현재 지점에서 용량이 다 참
				if(curW == W) {
					// 쓰레기장 간다.
					distance += xs[i];
					flag = true;
					curW = 0;
				}
			}
			
			// 다 돌고 쓰레기장 안 갔으면 감
			if(curW > 0) distance += xs[N-1];
			
			System.out.println(distance);
			
		}
	}
	
}