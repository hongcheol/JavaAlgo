package sangil.BOJ_1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	final static int MAX_NUM = 1001;
	static boolean[] primeNums = new boolean[MAX_NUM];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		// 배열의 값들을 모두 true로 채움
		Arrays.fill(primeNums, true);
		findPrimeNums();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int i = Integer.parseInt(st.nextToken());
			if(i==1) {
				continue;
			}
			if(primeNums[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	// 에라토스테네스 체 알고리즘으로 1001 까지의 소수 미리 구해놓고 시작
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
