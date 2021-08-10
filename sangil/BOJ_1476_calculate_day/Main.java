package sangil.BOJ_1476_calculate_day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 1;
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		while(true) {
			if(((result-E)%15==0)&&((result-S)%28==0)&&((result-M)%19==0)){
				break;
			}
			result++;
		}
		
		System.out.println(result);	
	}
}
