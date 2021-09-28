import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * LIS와 역방향 LIS 구한 후 합 최대인 길이 -1
 */
public class BOJ_11054 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine()),max = 0;
        int[] input = new int[n];
        int[][] lisLen = new int[2][n];//0은 정방향, 1은 역방향
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        for(int k = 0;k<n;k++){
            lisLen[0][k] = 1;
            for(int i = 0;i<k;i++){
                if(input[i]<input[k]){
                    lisLen[0][k] = lisLen[0][k]>lisLen[0][i]+1 ? lisLen[0][k] : lisLen[0][i]+1;
                }
            }
        }
        for(int k = n-1;k>=0;k--){
            lisLen[1][k] = 1;
            for(int i = n-1;i>=0;i--){
                if(input[i]<input[k]){
                    lisLen[1][k] = lisLen[1][k]>lisLen[1][i]+1 ? lisLen[1][k] : lisLen[1][i]+1;
                }
            }
        }
        for(int i = 0;i<n;i++){
            max = max>lisLen[0][i]+lisLen[1][i] ? max : lisLen[0][i]+lisLen[1][i];
        }
        System.out.println(max-1);
    }
}
