package sangil.BOJ_1016_not_square_num;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static final int LIMIT = 1000001;
	static long min, max;
	static long[] squares;
	static boolean[] squareNoNo;
	static int range;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		min = Long.parseLong(st.nextToken());
		max = Long.parseLong(st.nextToken());
		range = (int)(max - min + 1);
		
		calSquares();
		
		calSquareNoNo();
		
		int cnt = 0;
		for (int i = 0; i < range; i++) {
			if(squareNoNo[i]) cnt++;
		}
		System.out.println(cnt);
		
	}
	
	private static void calSquares() {
		squares = new long[LIMIT];
		for (long i = 1; i * i < (long)LIMIT * LIMIT; i++) {
			squares[(int)i] = i * i;
		}
	}
	
	private static void calSquareNoNo() {
		squareNoNo = new boolean[range];
		Arrays.fill(squareNoNo, true);
		
		for (int i = 2; i < squares.length; i++) {
			long start = (min % squares[i] == 0)? (min / squares[i]) : (min / squares[i])+1;
			
			while(true) {
				long squareMul = squares[i] * start++;
				if(squareMul > max) break;
				squareNoNo[(int)(squareMul-min)] = false;
			}
		}
	}
}
