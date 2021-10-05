package sangil.BOJ_1074_Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, r, c, cnt;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		traceZ(0, 0, (int)Math.pow(2, N));
		
		System.out.println(cnt);
	}
	
	private static void traceZ(int sX, int sY, int range) {
		if(range == 2) {
			for (int i = sX; i < sX + range; i++) {
				for (int j = sY; j < sY + range; j++) {
					if(i == r && j == c) return;
					cnt++;
				}
			}
		}
		
		else {
			int nRange = range/2;
			if(r < sX+nRange && c < sY+nRange) {
				traceZ(sX, sY, nRange);
			}else if(r < sX+nRange && c >= sY+nRange) {
				cnt += nRange * nRange;
				traceZ(sX, sY+nRange, nRange);
			}else if(r >= sX+nRange && c < sY+nRange) {
				cnt += nRange * nRange * 2;
				traceZ(sX+nRange, sY, nRange);
			}else {
				cnt += nRange * nRange * 3;
				traceZ(sX+nRange, sY+nRange, nRange);
			}
		}
	}
}
