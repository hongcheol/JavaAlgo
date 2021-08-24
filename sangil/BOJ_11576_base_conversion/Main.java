package sangil.BOJ_11576_base_conversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int A, B, M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int exp, dec = 0;
		while((exp = st.countTokens()) > 0) {
			// A진수 수를 10진수로 변환
			dec += Integer.parseInt(st.nextToken()) * Math.pow(A, exp-1);
		}
		
		StringBuilder sb = new StringBuilder();
		// 10진수 수를 B진수로 변환
		while(dec > 0) {
			sb.insert(0, dec % B + " ");
			dec /= B;
		}
		
		System.out.println(sb);
	}

}