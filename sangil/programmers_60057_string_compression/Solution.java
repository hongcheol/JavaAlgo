package sangil.programmers_60057_string_compression;


public class Solution {

	public static void main(String[] args) {
       System.out.println(solution("aabbaccc"));
       System.out.println(solution("ababcdcdababcdcd"));
       System.out.println(solution("abcabcdede"));
       System.out.println(solution("abcabcabcabcdededededede"));
       System.out.println(solution("xababcdcdababcdcd"));
       System.out.println(solution("aaaaaaaaaab"));
	}
	
    public static int solution(String s) {
        int answer = s.length();
        //sub string의 크기가 s.length()/2 보다 크면 비교 불가. 
        for (int i = 1; i < s.length() / 2 + 1; i++) {
        	StringBuilder sb = new StringBuilder();
        	// 처음 비교 대상
        	String temp = s.substring(0, i);
        	String remains = "";
        	int cnt = 1;
        	
			for (int j = i; j < s.length(); j += i) {
				// i만큼 못 자른 뒷 부분 생기면 저장하고 break;
				if(j+i > s.length()){
					remains = s.substring(j, s.length());
					break;
				}
				// 반복 되면 cnt++
				if(temp.equals(s.substring(j, j+i))) cnt++;
				else {
					if(cnt > 1) {
						sb.append(cnt);
						cnt = 1;
					}
					sb.append(temp);
					temp = s.substring(j, j+i);
				}
			}
			if(cnt > 1) {
				sb.append(cnt);
			}
			// 비교 하던 것과 뒤에 남은 부분 append
			sb.append(temp).append(remains);
			
			answer = Math.min(answer, sb.length());
			System.out.println(i + " " + sb.length() + " " + sb);
		}
        return answer;
    }
}
