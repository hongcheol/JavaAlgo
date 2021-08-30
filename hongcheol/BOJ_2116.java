import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2116 {
    static final int[] opposite = new int[]{5,3,4,1,2,0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] dice = new int[n][6];
        int[][] idx = new int[n][6];
        int max = 0;
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<6;j++){
                int now = Integer.parseInt(st.nextToken());
                dice[i][now-1] = j;
                idx[i][j] = now-1;
            }
        }
        int upper = 0,lower = 0,temp = 0;
        for(int i = 0;i<6;i++){
            upper = i;
            temp = 0;
            for(int j = 0;j<n;j++){
                lower = idx[j][opposite[dice[j][upper]]];
                if(lower+upper == 9) temp += 4;
                else if( upper == 5 || lower == 5) temp += 5;
                else temp += 6;
                upper = lower;
            }
            if(max<temp) max = temp;
        }
        System.out.println(max);
    }
}
