package sangil.BOJ_11052_buy_card;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] cards = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 1부터 n까지 카드 가격 입력
		for (int i = 1; i <= n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		// cost에는 index만큼의 카드를 사는 최대 비용을 저장한다.
		int[] cost = new int[n+1];
		// 1번부터 n번 카드까지 구입하는 경우를 순회한다.
		for (int i = 1; i <= n; i++) {
			//i가 카드의 갯수이므로 i개 이상의 카드를 살 때만 고려한다.
			for (int j = i; j <= n; j++) {
				// j개의 카드를 살 때 비용을 cost 배열의 값과 (현재 카드의 비용 + 현재 카드를 살 수 있을 때의 최댓값)비교하여 최대값을 갱신 한다.
				cost[j] = Math.max(cost[j], cards[i] + cost[j-i]);				
			}
		}
		
		System.out.println(cost[n]);
	}

}
