package sangil.BOJ_9465_sticker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] stickers = new int[2][N+1];
			int[][] scores = new int[2][N+1];
			
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					stickers[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			scores[0][1] = stickers[0][1];
			scores[1][1] = stickers[1][1];
			
			for (int i = 2; i <= N; i++) {
				// 대각선 순회를 위한 row index 설정
				int rowIdx = 0;
				for (int j = 0; j < 2; j++) {
					// 현재 0행 이면 1행을, 1행이면 0행의 값과 비교하게 한다.
					if(j==0) rowIdx = 1;
					else rowIdx = 0;
					// 현재 행의 대각선 왼쪽 위와 대각선 왼쪽 위의 왼쪽 칸의 값과 비교하여 큰 값을 현재 스티커의 점수를 더해서 저장한다.
					scores[j][i] = Math.max(scores[rowIdx][i-1], scores[rowIdx][i-2]) + stickers[j][i];
				}
			}
			
			System.out.println(Math.max(scores[0][N], scores[1][N]));
		}
		
	}
}
