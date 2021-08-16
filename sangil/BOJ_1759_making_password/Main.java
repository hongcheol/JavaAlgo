package sangil.BOJ_1759_making_password;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static int L, C;
	static char[] alphas, password;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		password = new char[L];
		alphas = new char[C];
		visited = new boolean[C+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alphas[i] = st.nextToken().charAt(0); 
		}
		
		Arrays.sort(alphas);
		
		dfs(0, 0, 0, 0);
		System.out.println(sb);
		
	}
	
	private static void dfs(int cnt, int start, int vowel, int consonant) {
		if(cnt == L) {
			//현재 완성된 password가 모음 1개 이상, 자음 2개 이상인지 확인한다.
			if(vowel >= 1 && consonant >= 2) {
				sb.append(password).append("\n");
			}
			return;
		}
		for (int i = start; i < alphas.length; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			password[cnt] = alphas[i];
			
			//현재 넣은 값이 모음이면 모음 갯수를 늘리고, 자음이면 자음 갯수를 늘린다.
			if(isVowel(alphas[i])) dfs(cnt+1, i+1, vowel+1, consonant);
			else dfs(cnt+1, i+1, vowel, consonant+1);
			
			visited[i] = false;
		}
	}
	
	private static boolean isVowel(char ch) {
		if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch == 'u') return true;
		return false;
	}
	
}
