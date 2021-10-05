package b10026;

import java.util.Scanner;

public class Main {
	static int N;
	static char[][] normal_map;
	static char[][] RG_map;
	static boolean[][] check;
	static int normal_cnt;
	static int RG_cnt;

	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		normal_map = new char[N][N];
		RG_map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				normal_map[i][j] = s.charAt(j);
				if (normal_map[i][j] == 'G')
					RG_map[i][j] = 'R';
				else
					RG_map[i][j] = normal_map[i][j];
			}
		}
		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j]) {
					check[i][j] = true;
					area(i, j, normal_cnt++, normal_map);
				}
			}
		}

		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j]) {
					check[i][j] = true;
					area(i, j, RG_cnt++, RG_map);
				}
			}
		}

		System.out.println(normal_cnt + " " + RG_cnt);

	}

	private static void area(int r, int c, int n, char[][] map) {
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !check[nr][nc]&&map[r][c] == map[nr][nc]) {
				check[nr][nc] = true;
				area(nr, nc, n, map);
			}
		}
	}

}
