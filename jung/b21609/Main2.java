package b21609;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {

	static int N, M;
	static int[][] map;
	static boolean[][] check;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int score;
	static int rainbow_max;
	static ArrayList<Point> blocks;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][N];
		score = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		while (true) {
			blocks = new ArrayList<Point>();
			rainbow_max = 0;
			breaking();

			if (blocks.size() <= 1)
				break;
			gravity();

			turn();

			gravity();

		}
		System.out.println(score);

		sc.close();

	}

	private static void turn() {
		int[][] turn_map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				turn_map[N - j - 1][i] = map[i][j];
			}
		}
		map = turn_map;
	}

	private static void gravity() {
		for (int i = N - 1; i >= 0; i--) {
			for (int j = N - 1; j >= 0; j--) {
				if (map[i][j] != -2 && map[i][j] != -1)
					down(i, j);
			}

		}
	}

	private static void down(int r, int c) {
		int h = -1;
		for (int i = r + 1; i < N; i++) {
			if (map[i][c] == -2) {
				h = i;
			} else if (map[i][c] == -1) {
				break;
			}
		}
		if (h != -1) {
			int tmp = map[r][c];
			map[r][c] = map[h][c];
			map[h][c] = tmp;
		}
	}

	private static void breaking() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int c = 1; c <= M; c++) {
					check = new boolean[N][N];
					if (map[i][j] == c && !check[i][j]) {
						find(i, j, c);
					}

				}
			}
		}
		if (blocks.size() > 1) {
			score += blocks.size() * blocks.size();
			for (Point p : blocks) {
				map[p.r][p.c] = -2;
			}
		}

	}

	private static void find(int r, int c, int num) {
		ArrayList<Point> block = new ArrayList<Point>();
		Queue<Point> point = new LinkedList<Point>();
		block.add(new Point(r, c));
		point.offer(new Point(r, c));
		int rainbow = 0;
		check[r][c] = true;
		while (!point.isEmpty()) {
			Point p = point.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dir[d][0];
				int nc = p.c + dir[d][1];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !check[nr][nc]) {
					if (map[nr][nc] == num) {
						check[nr][nc] = true;
						block.add(new Point(nr, nc));
						point.offer(new Point(nr, nc));
					} else if (map[nr][nc] == 0) {
						check[nr][nc] = true;
						rainbow++;
						block.add(new Point(nr, nc));
						point.offer(new Point(nr, nc));
					}

				}
			}
		}

		if (blocks.size() < block.size()) {
			rainbow_max = rainbow;
			blocks = block;
		} else if (blocks.size() == block.size()) {
			if (rainbow_max <= rainbow) {
				rainbow_max = rainbow;
				blocks = block;
			}
		}

	}

	private static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}

}
