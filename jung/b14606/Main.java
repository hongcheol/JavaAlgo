package b14606;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int score;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		score = 0;
		bfs(N);
		
		System.out.println(score);
		
	}
	
	private static void bfs(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(n);
		
		while(!q.isEmpty()) {
			int pizza = q.poll();
			int pizza_a = pizza/2;
			int pizza_b = pizza - pizza_a;
			score += pizza_a*pizza_b;
			if(pizza_a>1) {
				q.offer(pizza_a);
			}
			if(pizza_b>1) {
				q.offer(pizza_b);
			}
			
		}
		
	}

}
