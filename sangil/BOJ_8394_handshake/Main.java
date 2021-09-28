package sangil.BOJ_8394_handshake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		// n이 1이 들어와도 2까지는 만든다.
		int[] cnt = new int[N+2];
		
		// 3부터 순회할 것이므로 1과 2일때 값을 넣어놓는다.
		cnt[1] = 1;
		cnt[2] = 2;
		
		for(int i = 3; i <= N; i++) {
			cnt[i] = (cnt[i-1]+ cnt[i-2]) % 10;
		}
		
		System.out.println(cnt[N]);
		
	}
}
