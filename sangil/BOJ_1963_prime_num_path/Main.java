package sangil.BOJ_1963_prime_num_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int T, N, M, cnt;
	static boolean[] prime, visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			visited = new boolean[100000];
			
			// 소수들 구해놓는다.
			prime = new boolean[10000];
			Arrays.fill(prime, true);
			setPrime();
			
			cnt = 0;
			bfs(N);
			
			System.out.println(cnt);
		}
	}
	
	private static void bfs(int i) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(i);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(--size>=0) {
				int temp = queue.poll();
				visited[temp] = true;
				
				if(temp == M) return;
				// 1 -> 4자리 1개씩 변경
				for (int exp = 0; exp < 4; exp++) {
					//자릿 수 선택
					int digit = (int) Math.pow(10, exp);
					//해당 자릿수 0으로 만든 수 구한다. ex)7236, 1-> 7206
					int base = temp - (getBase(temp, exp) * digit);
					int r = 0;
					//1000의 자리면 1부터 시작.
					if(exp==3) r = 1;
					for (int k = r; k < 10; k++) {
						int next = base+digit*k;
						if(!visited[next] && prime[next]) {
							visited[next] = true;
							queue.offer(next);
						}
					}
				}
			}
			cnt++;
		}
		
	}
	
	private static int getBase(int n, int exp) {
		int result = 0;
		do {
			result = n % 10;
			n /= 10;
		}while(--exp>=0);
		
		return result;
	}
	
	// 에라토스체네스 체
	private static void setPrime() {
		for (int i = 2; i*i <= prime.length; i++) {
			if(prime[i]==true) {
				for (int j = 2; i*j < prime.length; j++) {
					prime[i*j] = false;
				}
			}
		}
	}

}