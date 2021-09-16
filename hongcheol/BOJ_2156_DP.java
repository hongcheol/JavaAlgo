import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 상향식으로 접근
 * 와인이 1잔이나 2잔만 있으면 다 마신다.
 * 그 이상이면 현재 시점(i번째 와인잔)에서 고를 수 있는 선택지는 다음 3가지 중 가장 큰 값이다.
 * 1. 2칸 전의 와인을 마신 후 지금 와인 마시기
 * 2. 이전 칸의 와인을 마신 후 지금 와인 안 마시기
 * 3. 3칸 전의 와인을 마신 후 지금이랑 직전 와인 마시
 */
public class BOJ_2156_DP {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] wine;
    static int[] drinked;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        wine = new int[n+1];
        drinked = new int[n+1];
        for(int i = 1;i<=n;i++){
            wine[i] = Integer.parseInt(br.readLine());
        }
        drinked[1] = wine[1];
        if(n==1) System.out.println(drinked[1]);
        else{
            drinked[2] = wine[1]+wine[2];
            if(n==2) System.out.println(drinked[2]);
            else{
                for(int i = 3;i<=n;i++){
                    drinked[i] = Math.max(Math.max(wine[i]+drinked[i-2],drinked[i-1]),wine[i]+wine[i-1]+drinked[i-3]);
                }
                System.out.println(drinked[n]);
            }
        }

    }
}
