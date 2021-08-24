package sangil.BOJ_1439_flip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] line = br.readLine().toCharArray();
		int cnt = 0;
		
		// 첫번째 char를 target으로 설정한다.
		char target = line[0];
		// 현재 뒤집을 대상들인지 나타낸다.
		boolean flag = false;
		for (int i = 1; i < line.length; i++) {
			if(flag) {
				// target과 같은 것이 나오면 그 전까지가 뒤집을 대상이다.
				if(target == line[i]) {
					cnt++;
					flag = false;
				}
			} else {
				// target과 다른 것이 나오면 그 때부터 뒤집을 대상이다.
				if(target != line[i]) {
					flag = true;	
				}
			}
		}
		// 다 끝나고 뒤집을 대상이 남았다면 뒤집는다.
		if(flag) cnt++;
		
		System.out.println(cnt);
	}
	
}
