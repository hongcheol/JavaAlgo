package b1016;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();


		boolean[] check = new boolean[(int) (max - min + 1)];
		int cnt = (int) (max - min + 1);
		for (long i = 2; i * i <= max; i++) {
			long squared = i * i;
			long start = min / squared + (min % squared == 0 ? 0 : 1);
			for (long j = start; j * squared <= max; j++) {
				if (!check[(int) ((j * squared) - min)]) {
					check[(int) ((j * squared) - min)] = true;
					cnt--;
				}
			}

		}

		System.out.println(cnt);

	}

}
