package b1074;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int cnt = 0;
		int t = 1;
		while(r!=0 || c!=0) {
			cnt += ((r%2)*2 + (c%2)*1)*t;
			t*=4;
			r /= 2;
			c /= 2;
		}
		
		System.out.println(cnt);
	}

}
