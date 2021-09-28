package sangil.BOJ_2146_shortest_bridge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, islandCnt, minDist;
	static int[][] board;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		minDist = Integer.MAX_VALUE;
		islandCnt = 2;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 각 섬 구분해서 번호 짓기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(board[i][j] == 1) {
					// islandCnt는 1과 구분 짓기 위해 2부터 시작한다.
					findIsland(i, j, islandCnt++);
				}
			}
		}
		
		// 섬의 땅 i,j에서 가장 가까운 다른 섬의 거리 잰다.
		// minDist로 최소 거리 갱신한다.
		loop:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(board[i][j] != 0) {
					buildBridge(i, j, board[i][j]);
					if(minDist == 1) break loop;
				}
			}
		}
		
		System.out.println(minDist);
	}
	
	private static void findIsland(int i, int j, int island) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int nx, ny;
		
		queue.offer(new int[] {i,j});
		board[i][j] = island;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();

			for (int d = 0; d < dx.length; d++) {
				nx = curr[0] + dx[d];
				ny = curr[1] + dy[d];
				
				// 연결되어 있는 1들은 같은 섬이다.
				if(nx>=0 && nx<N && ny>=0 && ny<N && board[nx][ny]==1) {
					board[nx][ny] = island;
					queue.offer(new int[] {nx, ny});
				}
			}
			
		}
	}
	
	private static void buildBridge(int i, int j, int islandNo) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][N];
		int nx, ny, dist;
		
		queue.offer(new int[] {i,j, 0});
		visited[i][j] = true;;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			dist = curr[2];
			// 현재까지의 거리가 최소 거리보다 크면 더 이상 탐색하지 않는다.
			if(dist > minDist) continue;
			
			for (int d = 0; d < dx.length; d++) {
				nx = curr[0] + dx[d];
				ny = curr[1] + dy[d];
				
				if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]) {
					// 바다이면 거리+1
					if(board[nx][ny] == 0) {
						visited[nx][ny] = true;
						queue.offer(new int[] {nx, ny, dist+1});
					// 다른 섬 연결
					} else if(board[nx][ny] != islandNo){
						// 현재 섬에서 가장 가까운 섬의 거리 갱신
						minDist = Math.min(minDist, dist);					
					}
				}
			}
			
		}
	}
}
