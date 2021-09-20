package b11052;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] card = new int[N+1];
		int[] money = new int[N+1];
		for (int i = 1; i <= N; i++) {
			card[i] = sc.nextInt();
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = i; j <=N; j++) {
				money[j] = Math.max(money[j], money[j-i]+card[i]);
			}
		}
		
		System.out.println(money[N]);
	}

}
