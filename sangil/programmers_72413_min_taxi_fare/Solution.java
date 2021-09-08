package sangil.programmers_72413_min_taxi_fare;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		System.out.println(solution(6,4,6,2,new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
		System.out.println(solution(7,3,4,1,new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}}));
		System.out.println(solution(6,4,5,6,new int[][] {{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}}));
	}
	
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int[][] adj = new int[n+1][n+1];
        
        for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj.length; j++) {
				if(i==j) adj[i][j] = 0;
				// 100000 * 200 + 1을  최대로
				else adj[i][j] = 200000001;
			}
		}
        
        for(int[] fare : fares) {
        	//양방향
        	adj[fare[0]][fare[1]] = fare[2];
        	adj[fare[1]][fare[0]] = fare[2];
        }
        
        // 플로이드-워셜
        for (int k = 1; k < adj.length; k++) {
			for (int i = 1; i < adj.length; i++) {
				for (int j = 1; j < adj.length; j++) {
					adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
				}
			}
		}
        
        // s->a + s->b
        answer = adj[s][a] + adj[s][b];
        for (int i = 1; i < n+1; i++) {
			if(i != s) {
				answer = Math.min(answer, adj[s][i] + adj[i][a] + adj[i][b]);
			}
		}
        
        return answer;
    }
}
