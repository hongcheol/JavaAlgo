package sangil.BOJ_2004_count_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cnt_5 = 0, cnt_2 = 0;
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		cnt_5 += cnt0(n, 5);
		cnt_5 -= cnt0(r, 5);
		cnt_5 -= cnt0(n-r, 5);
		
		cnt_2 += cnt0(n, 2);
		cnt_2 -= cnt0(r, 2);
		cnt_2 -= cnt0(n-r, 2);
		
		System.out.println(Math.min(cnt_5, cnt_2));	
	}
	
	private static int cnt0(int n, int i) {
		int cnt = 0;
		while(n >= i) {
			cnt += n/i;
			n /= i;
		}
		return cnt;
	}
	
}
