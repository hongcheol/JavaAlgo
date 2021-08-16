package sangil.BOJ_1697_hide_and_seek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static boolean[] visited;
	static int N, K, cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		visited = new boolean[100001];
		cnt = 0;
		
		bfs(N);
		System.out.println(cnt);
		
	}
	
	private static void bfs(int i) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(i);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(--size >= 0) {
				int temp = queue.poll();
				if(temp == K) return;
				visited[temp] = true;
				
				//현재 수에서 -1, +1, *2  값이 유효 범위인지, 첫 방문인지 확인하고 큐에 넣는다.
				if(isValidNum(temp-1)) queue.offer(temp-1);
				if(isValidNum(temp+1)) queue.offer(temp+1);
				if(isValidNum(temp*2)) queue.offer(temp*2);
			}
			cnt++;
		}
	}
	
	private static boolean isValidNum(int i) {
		if(i>=0 && i<=100000 && !visited[i]) return true;
		return false;
	}

}
