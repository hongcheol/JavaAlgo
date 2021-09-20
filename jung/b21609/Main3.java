package b21609;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main3 {

	static int N, M;
	static int[][] map;
	static int [][] check;
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
			blocks = new ArrayList<Point>(); // 부술 블럭 그룹
			rainbow_max = 0;
			breaking();

			if (blocks.size() <= 1)
				break;
			gravity();		// 중력
			turn();			// 회전
			gravity();		// 중력

			System.out.println(score);
		}

		sc.close();

	}

	private static void turn() {		// 회전
		int[][] copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			copy[i] = map[i].clone();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = copy[j][N - 1 - i];
			}
		}
	}

	private static void gravity() {		// 중력
		for (int i = N - 1; i >= 0; i--) {
			for (int j = N - 1; j >= 0; j--) {
				if (map[i][j]>=0)
					down(i, j);	// 비어있거나 검은색이 아니라면
			}

		}
	}

	private static void down(int r, int c) {		// 아래로
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

	private static void breaking() {		// 블럭 부수기
		check = new int[N][N];
		for (int c = 1; c <= M; c++) {
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == c && check[i][j]!=c) {		// 기준 블럭 찾기
						find(i, j, c);							// 블럭 그룹 찾기
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
		ArrayList<Point> block = new ArrayList<Point>();		// 블럭 그룹
		Queue<Point> point = new LinkedList<Point>();			// 찾는 부분
		block.add(new Point(r, c));
		point.offer(new Point(r, c));
		int rainbow = 0;
		check[r][c] = num;
		while (!point.isEmpty()) {
			Point p = point.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dir[d][0];
				int nc = p.c + dir[d][1];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && check[nr][nc] !=num) {
					if (map[nr][nc] == num) {				// 같은 색깔 찾기
						block.add(new Point(nr, nc));
						point.offer(new Point(nr, nc));
					} else if (map[nr][nc] == 0) {				// 무지개 블럭 찾기
						
						rainbow++;
						block.add(new Point(nr, nc));
						point.offer(new Point(nr, nc));
					}
					check[nr][nc] = num;

				}
			}
		}

		if (blocks.size() < block.size()) {				// 최대 블럭 그룹
			rainbow_max = rainbow;
			blocks = block;
		} else if (blocks.size() == block.size()) {		// 블럭 그룹 크기가 같으면 무지개 블럭이 많은 것
			if (rainbow_max <= rainbow) {				// 기준 블럭은 행 열 순서대로 들어온다.
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


	}

}
