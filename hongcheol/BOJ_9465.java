import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int testcase = Integer.parseInt(br.readLine());
        for(int t = 0;t<testcase;t++){
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][n+1];
            for(int i = 0;i<2;i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0;j<n;j++){
                    dp[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] += dp[1][0];
            dp[1][1] += dp[0][0];
            for(int i = 2;i<n;i++){
                dp[0][i] += Math.max(dp[1][i-1],dp[1][i-2]);
                dp[1][i] += Math.max(dp[0][i-1],dp[0][i-2]);
            }
            System.out.println(Math.max(dp[0][n-1],dp[1][n-1]));
        }
    }
}
