package sangil.BOJ_2331_repeat_sequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


/*
 * 중복이 시작되는 곳을 알아야 한다.
 * 배열로 하기에는 범위를 알기 힘들다.
 * 리스트에 값들을 저장해서 중복되는 값이 있는지 체크.
 * 
 * 하지만, 값은 중복될 수 없으므로 hash로 관리할 수 있다.
 * <Integer, Integer>로 관리하여 현재 key가 몇 번째로 온 수인지 기록할 수 있다.
 * 
 */
public class Main {
	
	static int A, P, cnt;
	static HashMap<Integer, Integer> D;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		D = new HashMap<Integer, Integer>();
		cnt = 1; 
		
		A = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		//현재 값을 key로 하고, 현재 값이 나타난 순서를 value로 한다.
		D.put(A, cnt++);
		int now = A, next = 0;
		
		while(true) {
			while(now > 0) {
				next += Math.pow((now%10), P);
				now /= 10;
			}
			// 이미 key가 있다면 그 수부터 반복된다고 할 수 있다.
			if(D.containsKey(next)) break;
			D.put(next, cnt++);
			now = next;
			next = 0;
		}
		
		// 반복되기 전 까지 길이는 반복이 시작되는 수의 이전까지이다.
		System.out.println(D.get(next)-1);
	}
	

}
