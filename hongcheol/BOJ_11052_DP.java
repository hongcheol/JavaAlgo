import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 0-1 knapsack 물건 여러개 버전.
 */
public class BOJ_11052_DP {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n+1];
        int[] memo = new int[n+1];

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 1;i<=n;i++){
            card[i] = Integer.parseInt(st.nextToken());
        }
        memo[1] = card[1];
        for(int i = 2;i<=n;i++){
            memo[i] = card[i];
            for(int j = 1;j<i+1;j++){
                int temp = memo[i - j] + card[j];//이번꺼 사는 경우
                if(memo[i]< temp) memo[i] = temp;//이번 카드팩 사는게 이득인 경우
            }
        }//카드 장수만큼 반복문을 돌려서 여러번 구매하는 것처리.
        System.out.println(memo[n]);
    }
}
