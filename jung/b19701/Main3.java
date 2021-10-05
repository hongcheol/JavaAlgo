package b19701;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
	static int[][][] arr;
	static int INF = 300000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();


		initAdj(V);
		for (int i = 0; i < E; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int t = sc.nextInt();
			int k = sc.nextInt();

			arr[x][y][0] = t;
			arr[x][y][1] = k;

		}

		 for (int k = 1; k <= V; k++) {
		        for (int i = 1; i <= 1; i++) {
		        	if(i==k) continue;
		            for (int j = 1; j <= V; j++) {
		            	if(j==k) continue;
		            	int t = arr[i][k][0] + arr[k][j][0];
		            	int e = Math.max(arr[i][k][1], arr[k][j][1]);
		            	if(arr[i][j][0] - arr[i][j][1] > t-e) {
		            		arr[i][j][0] = t;
		            		arr[i][j][1] = e;
		            	}
		            }
		        }
		 }

		for (int i = 2; i <= V; i++) {
			System.out.println(arr[1][i][0] - arr[1][i][1]);

		}

	}
	
	private static void initAdj(int V) {
		arr = new int[V + 1][V + 1][2];
	    int i, j;
	    for (i = 0; i <= V; i++)
	        for (j = 0; j <= V; j++) {
	            arr[i][j][0] = INF;
	            if (i == j)arr[i][j][0] = 0;
	        }
	}

}
