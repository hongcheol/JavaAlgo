package sangil.programmers_67260_explore_cave;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int[] save;
	static HashMap<Integer, Integer>locked;
	
	public static void main(String[] args) {
       System.out.println(solution(9, new int[][] {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}}, new int[][] {{8,5},{6,7},{4,1}}));
       System.out.println(solution(9, new int[][] {{8,1},{0,1},{1,2},{0,7},{4,7},{0,3},{7,5},{3,6}}, new int[][] {{4,1},{5,2}}));
       System.out.println(solution(9, new int[][] {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}}, new int[][] {{4,1},{8,7},{6,5}}));
       System.out.println(solution(4, new int[][] {{0,1},{1,2},{2,3},{3,0}}, new int[][] {{3,1}}));
	}
	
    public static boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;
        graph = new ArrayList<>();
        visited = new boolean[n];
        save = new int[n];
        locked = new HashMap<Integer, Integer>();
        
        // graph 초기화
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 양방향
        for (int[] p : path) {
            graph.get(p[0]).add(p[1]);
            graph.get(p[1]).add(p[0]);
        }
        
        for(int[] lock : order) {
        	// 시작 노드(0)가 잠겨있다면 false 
        	if(lock[1] == 0) return false;
        	// b 이전에 방문해야 하는 노드 a 저장
        	locked.put(lock[1], lock[0]);
        }
        
        bfs(n, 0);
        
        for(boolean visit : visited) {
        	if(!visit) return false;
        }
        
        return answer;
    }
    
    public static void bfs(int n, int start) {
    	Queue<Integer> queue = new LinkedList<Integer>();
    	
    	queue.offer(start);
    	
    	while(!queue.isEmpty()) {
    		int current = queue.poll();
    		visited[current] = true;
    		
    		// 현재 노드 방문 후 방문해야 하는 노드가 있다면
    		if(save[current] > 0) {
    			// 잠금을 해제한다.
    			locked.remove(save[current]);
    			// 그 노드를 큐에 넣는다.
    			queue.offer(save[current]);
    		}
    		
    		for(int v : graph.get(current)) {
    			if(visited[v]) continue;
    			// v 노드가 잠겨있다면 key 노드 방문시 큐에 넣도록 save한다.
    			if(locked.containsKey(v)) {
    				// 이미 key를 방문했다면
    				if(visited[locked.get(v)]) {
    					// v 노드 방문
    					queue.offer(v);
    				// 그렇지 않으면 save에 v 저장
    				} else save[locked.get(v)] = v;
    			}
    			else queue.offer(v);
    		}
    	}
    }
}
