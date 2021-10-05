import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2225 {
    static final int MOD = 1000000000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][k+1];
        dp[0][0] = 1;
        for(int i = 0;i<=n;i++){
            for(int j = 1;j<=k;j++){
                for(int l = 0;l<=i;l++){
                    dp[i][j] += dp[i-l][j-1];
                    dp[i][j] %= MOD;
                }
            }
        }
        System.out.println(dp[n][k]);

    }
}
