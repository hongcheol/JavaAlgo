package sangil.BOJ_1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	final static int MAX_NUM = 1000001;
	static boolean[] primeNums = new boolean[MAX_NUM];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Arrays.fill(primeNums, true);
		findPrimeNums();
		primeNums[1] = false;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		for(int i = a; i<=b; i++) {
			if(primeNums[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
		
	}
	
	public static void findPrimeNums() {
		for (int i = 2; i < MAX_NUM; i++) {
			if(primeNums[i]) {
				for (int j = 2; i*j < MAX_NUM; j++) {
					primeNums[i*j] = false;
				}
			}
		}
	}
	
}
