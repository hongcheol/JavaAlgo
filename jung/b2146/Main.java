package b2146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int island_num = 2;
	static int N;
	static int[][] arr;
	static boolean[][] check;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		check = new boolean[N][N];

		for (int r = 0; r < N; r++) {		//맵 입력
			String[] s = in.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(s[c]);
			}
		}

		for (int r = 0; r < N; r++) {		//섬 판별
			for (int c = 0; c < N; c++) {
				if (arr[r][c] == 1) {
					arr[r][c] = island_num;
					island(r, c, island_num++);
				}
			}
		}


		for (int r = 0; r < N; r++) {		// 다리놓기
			for (int c = 0; c < N; c++) {
				if (arr[r][c] > 1) {
					check = new boolean[N][N];
					check[r][c] = true;
					bridge(r, c, arr[r][c], 0);
				}
			}
		}

		System.out.println(min);

	}

	private static void island(int r, int c, int num) {	// 섬 구분하기
		int n_r;
		int n_c;

		for (int d = 0; d < 4; d++) {
			n_r = r + dir[d][0];
			n_c = c + dir[d][1];
			if (n_r >= 0 && n_r < N && n_c >= 0 && n_c < N && arr[n_r][n_c] == 1) {	//연결된 섬이면 같은 번호로
				arr[n_r][n_c] = num;
				island(n_r, n_c, num);
			}
		}
	}

	private static void bridge(int r, int c, int num, int cnt) {	// bfs로  다리만들기
		int n_r;
		int n_c;
		Queue<Point> point = new LinkedList<Point>();
		point.offer(new Point(r, c, num, 0));
		Loop: while(!point.isEmpty()) {
			Point p = point.poll();
			for (int d = 0; d < 4; d++) {
				n_r = p.r + dir[d][0];
				n_c = p.c + dir[d][1];
				if (n_r >= 0 && n_r < N && n_c >= 0 && n_c < N && !check[n_r][n_c]) {
					check[n_r][n_c] = true;
					if (arr[n_r][n_c] == num) {		//같은 섬이면 넘어가기
						continue;
					} else if (arr[n_r][n_c] != 0) {	// 다른 섬이면 종료
						min = Math.min(min, p.cnt);
						break Loop;
					} else {
						point.add(new Point(n_r,n_c,num,p.cnt+1));		// 바다면 다리 놓기
					}
				}
			}
			
		}


	}
	
	public static class Point{
		int r,c,num,cnt;

		public Point(int r, int c, int num, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
			this.cnt = cnt;
		}

		
		
	}

}
