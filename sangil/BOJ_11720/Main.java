package sangil.BOJ_11720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		String nStr = br.readLine();
		int result = 0;
		
		for (int i = 0; i < nStr.length(); i++) {
			result += nStr.charAt(i) - '0';
		}
		
		System.out.println(result);
		
	}

}
