package b11725;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] check;
	static ArrayList<Integer>[] lines;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1];
		check = new boolean[N+1];
		lines = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			lines[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N-1; i++) {
			int p1= sc.nextInt();
			int p2 = sc.nextInt();
			lines[p1].add(p2);
			lines[p2].add(p1);
		}
		
		dfs(1);
		
		for (int i = 2; i <= N; i++) {
			System.out.println(arr[i]);
		}
	}
	
	private static void dfs(int n) {
		check[n] = true;
		for (int line : lines[n]) {
			if(!check[line]) {
				arr[line] = n;
				dfs(line);
			}
		}
	}

}
