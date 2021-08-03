package sangil.BOJ_11655_ROT13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if((ch >= 'a' && ch < 'n') || (ch >= 'A' && ch < 'N')) {
				ch += 13;
			// 13을 더했을 때 범위를 넘어가는 값들은 13을 빼준 것과 같다.
			} else if ((ch >= 'n' && ch <= 'z') || (ch >= 'N' && ch <= 'Z')) {
				ch -= 13;
			}
			sb.append(ch);
		}
		System.out.println(sb);	
	}
}
