package sangil.BOJ_9461_wave_sequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			if(N <= 3) System.out.println(1);
			else {
				long[] P = new long[N+1];
				
				P[1] = 1;
				P[2] = 1;
				P[3] = 1;
				
				for (int i = 4; i <= N; i++) {
					P[i] = P[i-2] + P[i-3];
				}
				
				System.out.println(P[N]);
			}
		}
		
	}
}
