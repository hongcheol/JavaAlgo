package sangil.BOJ_9613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		//유클리드 호제법 이용
		for (int tc = 0; tc < T; tc++) {
			ArrayList<Integer> nums = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			long result = 0;
			
			for (int i = 0; i < n; i++) {
				nums.add(Integer.parseInt(st.nextToken()));
			}
//			nums.sort(Comparator.reverseOrder());
			Collections.sort(nums, new Comparator<Integer>() {
				@Override
				public int compare(Integer a, Integer b) {
					if(a.intValue()>b.intValue()) {
						return 1;
					}else {
						return -1;
					}
				}
			});
			
			for (int i = 0; i < nums.size(); i++) {
				for (int j = i+1; j < nums.size(); j++) {
					result += gcd(nums.get(i), nums.get(j));
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int gcd(int a, int b) {
		int r;
		if((r = a%b) == 0) {
			return b;
		} 
		return gcd(b,r);
	}
		
		// 약수 모두 찾아서 비교
//		for (int tc = 0; tc < T; tc++) {
//			ArrayList<ArrayList<Integer>> aliquots = new ArrayList<ArrayList<Integer>>();
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			long sum = 0;
//			int n = Integer.parseInt(st.nextToken());
//			for (int i = 0; i < n; i++) { 
//				aliquots.add(calAliquots(Integer.parseInt(st.nextToken())));
//			}
//			
//			for (int i = 0; i < aliquots.size(); i++) {
//				for (int j = i+1; j < aliquots.size(); j++) {
//					sum += calGCD(aliquots.get(i), aliquots.get(j));
//				}
//			}
//			sb.append(sum).append("\n");
//		}
//		System.out.println(sb);	
//	}
	
	
	public static ArrayList<Integer> calAliquots(int num) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for (int i = 1; i*i <= num; i++) {
			if(num % i == 0) {
				int index = result.size()/2;
				result.add(index, i);
				result.add(index+1, num/i);
			}
		}	
		return result;
	}
	
	public static int calGCD(ArrayList<Integer> l1, ArrayList<Integer> l2) {
		int result = 1;
		check:
		for (int i = l1.size()-1; i >= 0; i--) {
			for (int j = l2.size()-1 ; j >= 0; j--) {
				if(l1.get(i) > l2.get(j)) {
					break;
				} else if(l1.get(i).equals(l2.get(j))) {
					result = l1.get(i);
					break check;
				}
			}
		}
		return result;
	}
	
}


/*
3
4 10 20 30 40
3 7 5 12
3 125 15 25

1
5 1 1 1 1 1

1
100 1000000 1000000 10000000 10000000 10000000 1000000 1000000 10000000 10000000 10000000 1000000 1000000 10000000 10000000 10000000 1000000 1000000 10000000 10000000 10000000 1000000 1000000 10000000 10000000 10000000 1000000 1000000 10000000 10000000 10000000 1000000 1000000 10000000 10000000 10000000 1000000 1000000 10000000 10000000 10000000 1000000 1000000 10000000 10000000 10000000 1000000 1000000 10000000 10000000 10000000 1000000 1000000 10000000 10000000 10000000 1000000 1000000 10000000 10000000 10000000 1000000 1000000 10000000 10000000 10000000 1000000 1000000 10000000 10000000 10000000 1000000 1000000 10000000 10000000 10000000 1000000 1000000 10000000 10000000 10000000 1000000 1000000 10000000 10000000 10000000 1000000 1000000 10000000 10000000 10000000 1000000 1000000 10000000 10000000 10000000 1000000 1000000 10000000 10000000 10000000

*
*/
