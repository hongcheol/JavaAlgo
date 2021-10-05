package b19701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main4 {
	private static class Node implements Comparable<Node>{
		int start,end,time,value;


	



		public Node(int start, int end, int time, int value) {
			super();
			this.start = start;
			this.end = end;
			this.time = time;
			this.value = value;
		}






		@Override
		public String toString() {
			return "Node [start=" + start + ", end=" + end + ", time=" + time + ", value=" + value + "]";
		}






		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.time, o.time);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		ArrayList<Node>[] arr = new ArrayList[V+1];
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		int[][] city = new int[V + 1][2];
		boolean[] check = new boolean[V + 1];
		for (int i = 1; i <= V; i++) {
			city[i][0] = Integer.MAX_VALUE;
			arr[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			arr[x].add(new Node(x, y, t, k));

		}
		city[1][0] = 0;
		pq.add(new Node(1, 1, 0, 0));
		int cnt = 0;
		while(!pq.isEmpty()) {
			Node n = pq.poll();


			check[n.end] = true;
			
			if(city[n.end][0]-city[n.end][1] > city[n.start][0] + n.time - Math.max(city[n.start][1], n.value)) {
				city[n.end][0] = city[n.start][0] + n.time;
				city[n.end][1] = Math.max(city[n.start][1], n.value);
			}

			for (Node next : arr[n.end]) {
				if(!check[next.end]) pq.add(next);
				
			}
		}
		
		for (int i = 2; i <= V; i++) {
			System.out.println(city[i][0] - city[i][1]);
		}
		
	}

}
