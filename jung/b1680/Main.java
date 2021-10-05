package b1680;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int W, N;
		
		for (int t = 0; t < T; t++) {
			W = sc.nextInt();
			N = sc.nextInt();
			Queue<int[]> q = new LinkedList<int[]>();
			int len;
			int weight;
			for (int i = 0; i < N; i++) {
				len = sc.nextInt();
				weight = sc.nextInt();
				q.offer(new int[] {len,weight});
			}
			int w = 0;
			int l = 0;
			while(!q.isEmpty()) {
				int [] arr = q.poll();
				if(w+arr[1]>W) {	// 쓰레기의 양이 용량이 넘을 때
					w=0;
					l+=arr[0]*2;
				}
				if(w+arr[1]==W) {	// 쓰리기의 양이 용량에 딱 맞을 때
					w=0;
					l+=arr[0]*2;
				}
				else {				// 쓰리기의 양이 요량을 채우지 못하였 을 때
					w+=arr[1];
					if(q.isEmpty()) l+=arr[0]*2;
				}
			}
			
			System.out.println(l);
		}
	}

}
