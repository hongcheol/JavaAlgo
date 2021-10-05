package sangil.BOJ_10026_redgreen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static char[][] board;
	static int N;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[] areaArr;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		areaArr = new int[3];
		
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		// R,G,B 3개를 찾는다.
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 방문하지 않았다면
				if(!visited[i][j]) {
					// i,j부터 영역을 찾는다.
					findArea(i, j);
					// 찾은 영역의 색 그룹 +1
					areaCount(board[i][j]);
				}
			}
		}
		
		sb.append(areaArr[0]+areaArr[1]+areaArr[2]).append(" ");
		
		// R자리 다시 count하기 때문에 초기화
		areaArr[0] = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// R인곳만 방문한다.
				// B는 이전에 찾은 것과 같기 떄문에
				if(!visited[i][j] && board[i][j] == 'R') {
					findArea(i, j);
					areaCount(board[i][j]);
				}
			}
		}
		
		sb.append(areaArr[0]+areaArr[2]);
		
		System.out.println(sb);
	}
	
	private static void findArea(int sX, int sY) {
		Queue<int[]> queue = new LinkedList<int[]>();
		char color = board[sX][sY];
		int nx, ny;
		
		queue.offer(new int[] {sX, sY});
		visited[sX][sY] = true;
		// 두번째로 찾을 때 G인  부분은 R과 같게 보기 위해서
		// 방문처리 후에 R로 바꿔준다.
		if(board[sX][sY]=='G') board[sX][sY] = 'R'; 
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			for (int d = 0; d < dx.length; d++) {
				nx =  curr[0] + dx[d];
				ny =  curr[1] + dy[d];
				
				if(validCheck(nx, ny) && !visited[nx][ny] && board[nx][ny] == color) {
					visited[nx][ny] = true;
					queue.offer(new int[] {nx,ny});
					
					// 두번째로 찾을 때 G인  부분은 R과 같게 보기 위해서
					// 방문처리 후에 R로 바꿔준다.
					if(board[nx][ny]=='G') board[nx][ny] = 'R'; 
				}
			}
		}
	}
	
	private static boolean validCheck(int nx, int ny) {
		return (nx>=0 && nx<N && ny>=0 && ny<N);
	}
	
	private static void areaCount(char color) {
		switch (color) {
		case 'R':
			areaArr[0]++;
			break;
		case 'G':
			areaArr[1]++;
			break;
		case 'B':
			areaArr[2]++;
			break;
		}
	}
}
