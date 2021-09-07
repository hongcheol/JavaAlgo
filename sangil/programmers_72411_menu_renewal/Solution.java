package sangil.programmers_72411_menu_renewal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
	
	static HashMap<String, Integer> menuMap;
	
	public static void main(String[] args) {
       System.out.println(Arrays.deepToString(solution(new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[] {2,3,4})));
       System.out.println(solution(new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[] {2,3,5}));
       System.out.println(solution(new String[] {"XYZ", "XWY", "WXA"}, new int[] {2,3,4}));
	}
	
    public static String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<String>();
        menuMap = new HashMap<String, Integer>();
        
        // orders <= 20, course <= 10  
        // 메뉴 조합
        for(int i = 0; i < orders.length; i++) {
        	for(int n : course) {
        		// 주문된 메뉴 수가 조합 목표보다 작으면 continue
        		if(orders[i].length() < n) continue;
        		char[] order = orders[i].toCharArray();
        		// key값 통일하기 위해 오름차순 정렬
        		Arrays.sort(order);
        		combi(0, 0, n, order, "");
        	}
        }
        
        // 각 course 별로 최다 주문 횟수 저장
        int[] maxCnt = new int[course[course.length -1] +1];
        for(String menu : menuMap.keySet()) {
        	if(menuMap.get(menu) >= 2) {
        		maxCnt[menu.length()] = Math.max(maxCnt[menu.length()], menuMap.get(menu));
        	}
        }
        
        for(String menu : menuMap.keySet()) {
        	// 최다 주문 횟수와 같은 menu들 저장
        	if(menuMap.get(menu) == maxCnt[menu.length()]) answer.add(menu);
        }
        
        answer.sort(null);
        
        return answer.toArray(new String[answer.size()]);
    }
    
    public static void combi(int start, int cnt, int n, char[] order, String menu) {
    	if(cnt == n) {
    		menuMap.put(menu, menuMap.getOrDefault(menu, 0)+1);
    		return;
    	}
    	for (int i = start; i < order.length; i++) {
    		combi(i+1, cnt+1, n, order, menu+order[i]);
			
		}
    }
}
