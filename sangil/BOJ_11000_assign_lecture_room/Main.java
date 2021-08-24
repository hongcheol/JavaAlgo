package sangil.BOJ_11000_assign_lecture_room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, cnt;
	static Integer[][] lectures;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		cnt = 0;
		lectures = new Integer[N][2];
		
		//우선 순위 큐로 강의 시작 시간이 빠른 순으로 강의를 관리한다. 
		PriorityQueue<int[]> lectures2 = new PriorityQueue<int[]>((o1, o2) -> o1[0]-o2[0]);
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lectures2.offer(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}		
		
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
		// 첫번째 강의가 끝나는 시간을 넣는다.
		pQueue.offer(lectures2.poll()[1]);
		while (!lectures2.isEmpty()) {
			// 기존 강의가 끝나는 시간보다 현재 강의 시작 시간이 느리면 같은 강의실을 사용할 수 있다.
			if(pQueue.peek() <= lectures2.peek()[0]) {
				pQueue.poll();
			}
			// 강의가 끝나는 시간을 넣는다.
			pQueue.offer(lectures2.poll()[1]);
		}
		// 강의실을 같이 쓸 수 있는 것들을 교환이 모두 되었기 때문에 현재 강의하고 있는 수가 필요한 강의실 수이다.
		System.out.println(pQueue.size());
	}	
		
		// 배열로 강의 관리
//		lectures = new Integer[N][2];
//		
//		for (int i = 0; i < N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < 2; j++) {
//				lectures[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}		
//		
//		Arrays.sort(lectures, (o1, o2) -> o1[0]-o2[0]);
		
//		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
//		pQueue.offer(lectures[0][1]);
//		for (int i = 1; i < lectures.length; i++) {
//			if(pQueue.peek() <= lectures[i][0]) {
//				pQueue.poll();
//			}
//			pQueue.offer(lectures[i][1]);
//			cnt = Math.max(cnt, pQueue.size());
//		}
//		
//		System.out.println(cnt);
//	}	
	
}

