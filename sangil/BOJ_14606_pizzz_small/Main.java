package sangil.BOJ_14606_pizzz_small;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] maxHappiness;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N==1) System.out.println(0);
		else {
			maxHappiness = new int[N+1];
			maxHappiness[1] = 0;
			
			for (int i = 2; i <= N; i++) {
				for (int j = 1; j <= i/2; j++) {
					maxHappiness[i] = Math.max(maxHappiness[i], j*(i-j) + maxHappiness[j]+maxHappiness[i-j]);
				}
			}
			
			System.out.println(maxHappiness[N]);
		}
	}
}
