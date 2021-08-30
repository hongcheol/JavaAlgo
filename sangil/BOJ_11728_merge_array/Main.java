package sangil.BOJ_11728_merge_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arrA, arrB, arrM;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arrA = new int[N];
		arrB = new int[M];
		arrM = new int[N+M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		
		int idxA = 0, idxB = 0, idxM = 0;
		while(idxM < N+M) {
			//A 배열의 포인터가 끝이면 B 배열 값만 넣어준다.
			if(idxA == N) {
				arrM[idxM++] = arrB[idxB++];
				continue;
			//B 배열의 포인터가 끝이면 A 배열 값만 넣어준다.
			}else if(idxB == M) {
				arrM[idxM++] = arrA[idxA++];
				continue;
			}
			//A 배열 포인터의 값과 B 배열 포인터의 값을 비교하여 작은 값을 넣어준다.
			//값이 선택된 배열의 포인터를 증가시킨다.
			if(arrA[idxA] < arrB[idxB]) {
				arrM[idxM++] = arrA[idxA++]; 
			} else {
				arrM[idxM++] = arrB[idxB++]; 
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : arrM) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

}
