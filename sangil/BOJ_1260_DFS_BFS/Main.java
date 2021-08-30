package sangil.BOJ_1260_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] graph;
	static boolean[] visited;
	static int N, M, V;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			//양방향 그래프
			graph[n1][n2] = graph[n2][n1] = 1;
		}
		
		visited = new boolean[N+1];
		dfs(V);
		sb.append("\n");
		
		visited = new boolean[N+1];
		bfs(V);
		System.out.println(sb);
	}
	
	private static void dfs(int i) {
		visited[i]= true;
		sb.append(i).append(" ");
		
		for (int j = 1; j < graph[i].length; j++) {
			if(visited[j] || graph[i][j] != 1) continue; 		
			dfs(j);
		}
	}
	
	private static void bfs(int i) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(i);
		visited[i] = true;
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			sb.append(temp).append(" ");
			
			for(int j = 1; j < graph[temp].length; j++) {
				if(visited[j] || graph[temp][j] != 1) continue;
				
				queue.offer(j);
				visited[j] = true;
			}
		}
		
		
	}

}
