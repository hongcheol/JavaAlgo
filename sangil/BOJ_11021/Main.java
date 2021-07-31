package sangil.BOJ_11021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			String str = br.readLine();
			StringTokenizer sc = new StringTokenizer(str);
			
			int a = Integer.parseInt(sc.nextToken());
			int b = Integer.parseInt(sc.nextToken());	
			
			System.out.printf("Case #%d: %d%n", tc+1, a+b);
		}	

	}

}
