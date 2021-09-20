package b9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(in.readLine());
			
			int[][] arr = new int[2][N+1];
			int[][] result = new int[2][3];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
				
			}
			result[0][1] = arr[0][1];
			result[1][1] = arr[1][1];
			
			for (int i = 2; i <= N; i++) {
				result[0][2] = Math.max(result[1][1]+arr[0][i], result[1][0] +arr[0][i]);
				result[1][2] = Math.max(result[0][1]+arr[1][i],  result[0][0] + arr[1][i]);
				for (int j = 0; j < 2; j++) {
					result[0][j] = result[0][j+1];
					result[1][j] = result[1][j+1];
				}
			}

			
			System.out.println(Math.max(result[0][1], result[1][1]));
			
		
		}
		
	}

}
