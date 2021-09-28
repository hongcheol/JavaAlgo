package b19701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		ArrayList<int[]>[] arr;
		int[][] city = new int[V + 1][2];
		boolean[] check = new boolean[V + 1];
		arr = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			arr[i] = new ArrayList<int[]>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			arr[x].add(new int[] { y, t, k });

		}
		for (int i = 2; i <= V; i++) {
			city[i][0] = 1000000;
		}
		// check[1] = true;
		for (int i = 1; i <= V; i++) {
			// 1. 아직 경유지로 고려되지 않은 정점 중에 출발지에 가장 가까운 정점을 선택한다.
			int min_l = Integer.MAX_VALUE;
			int max_d = 0;
			int current = 0;
			for (int j = 1; j <= V; j++) {
				if (!check[j] && min_l - max_d > city[j][0] - city[j][1]) {
					min_l = city[j][0];
					max_d = city[j][1];
					current = j;
				}
			}
			check[current] = true;
			// 2. 현재 선택된 정점을 경유지로해서 아직 처리하지 않은 나머지정점들과의 거리를 계산해서 더 최소이면 갱신
			for (int[] line : arr[current]) {
				int y = line[0];

				int l = line[1] + city[current][0];
				int d = Math.max(line[2], city[current][1]);
				if (city[y][0] - city[y][1] > l - d) {
					city[y][0] = l;
					city[y][1] = d;
					check[y] =false;
				}

			}
		}
		for (int i = 2; i <= V; i++) {
			System.out.println(city[i][0] - city[i][1]);

		}

	}

}
