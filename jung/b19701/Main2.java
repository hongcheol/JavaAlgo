package b19701;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		int[][] city = new int[V + 1][2];
		boolean[] check = new boolean[V + 1];

		int[][][] arr = new int[V + 1][V + 1][2];
		for (int i = 0; i < E; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int t = sc.nextInt();
			int k = sc.nextInt();

			arr[x][y][0] = t;
			arr[x][y][1] = k;

		}
		for (int i = 2; i <= V; i++) {
			city[i][0] = Integer.MAX_VALUE;
		}
		// check[1] = true;

		for (int i = 1; i <= V; i++) {
			// 1. 아직 경유지로 고려되지 않은 정점 중에 출발지에 가장 가까운 정점을 선택한다.
			int min_l = Integer.MAX_VALUE;
			int max_d = 0;
			int current = -1;
			for (int j = 1; j <= V; j++) {
				if (!check[j] && min_l - max_d > city[j][0] - city[j][1]) {
					min_l = city[j][0];
					max_d = city[j][1];
					current = j;
				}
			}
			check[current] = true;


			// 2. 현재 선택된 정점을 경유지로해서 아직 처리하지 않은 나머지정점들과의 거리를 계산해서 더 최소이면 갱신

			for (int j = 1; j <= V; j++) {
				int l = arr[current][j][0] + min_l;
				int d = Math.max(arr[current][j][1], max_d);
				if (!check[j] && arr[current][j][0] != 0
						&& city[j][0] - city[j][1] > l - d) {
					city[j][0] = l;
					city[j][1] = d;
				}

			}
		}

		for (int i = 2; i <= V; i++) {
			System.out.println(city[i][0] - city[i][1]);

		}

	}

}
