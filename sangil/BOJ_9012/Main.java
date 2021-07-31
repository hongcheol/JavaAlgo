package sangil.BOJ_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			String s = br.readLine();
			boolean isVPS = true;
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if(ch == '(') {
					stack.push(ch);
				} else if(stack.empty()) {
					sb.append("NO").append("\n");
					isVPS = false;
					break;
				} else {
					stack.pop();
				}
			}
			if(isVPS && stack.empty()) {
				sb.append("YES").append("\n");
			} else if(!stack.empty()){
				sb.append("NO").append("\n");
			}
			stack.clear();
		}
		System.out.println(sb);	
	}
}
