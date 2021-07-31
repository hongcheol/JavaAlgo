package sangil.BOJ_11656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		String[] strs = new String[s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			strs[i] = s.substring(i, s.length());
		}
		Arrays.sort(strs);
		
		for (String str : strs) {
			sb.append(str).append("\n");
		}
		System.out.println(sb);
	}

}
