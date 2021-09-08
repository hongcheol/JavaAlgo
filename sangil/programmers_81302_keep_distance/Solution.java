package sangil.programmers_81302_keep_distance;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
       System.out.println(Arrays.toString(solution(new String[][] {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})));
	}
	
    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);
        int cnt = 0;
        
        for(String[] place : places) {
        	loop:
        	for(int i = 0; i < place.length; i++){
        		for (int j = 0; j < place[i].length(); j++) {
        			if(place[i].charAt(j) == 'P') {
        				if(!bfs(place, i, j)) {
        					answer[cnt] = 0;
        					break loop;
        				}
        			}
        		}
        	}
        	cnt++;
        }
        return answer;
    }
    
    
    public static boolean bfs(String[] place, int r, int c) {
    	Queue<int[]> queue = new LinkedList<int[]>();
    	boolean[][] visited = new boolean[place.length][place.length];
    	
    	queue.offer(new int[]{r,c});
    	visited[r][c] = true;
    	
    	while(!queue.isEmpty()) {
    		int[] current = queue.poll();
    		
    		//상하좌우 탐색
    		for (int i = 0; i < 4; i++) {
				int nr = current[0] + dr[i];
				int nc = current[1] + dc[i];
				
				if(nr<0 || nr>=place.length || nc<0 || nc>=place.length) continue;
				if(visited[nr][nc] || Math.abs(nr-r)+Math.abs(nc-c) > 2) continue;
				
				visited[nr][nc] = true;
				if(place[nr].charAt(nc) == 'P') return false;
				else if(place[nr].charAt(nc) == 'X') continue;
				
				queue.offer(new int[]{nr, nc});
			}
    	}
    	return true;
    }
}
