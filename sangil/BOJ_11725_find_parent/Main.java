package sangil.BOJ_11725_find_parent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static ArrayList<Integer>[] adjList;
	static int[] parents;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		adjList = new ArrayList[N+1];
		parents = new int[N+1];
		
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			adjList[v1].add(v2);
			adjList[v2].add(v1);
			
		}
		
		bfs(1);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(parents[i]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void bfs(int root) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(root);
		parents[root] = 1;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for (Integer i :  adjList[curr]) {
				if(parents[i] == 0) {
					parents[i] = curr;
					queue.offer(i);
				}
			}
		}
	}

}
