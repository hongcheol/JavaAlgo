import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int cnt = 0;
    static int R,C;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int size = 1 << n;
        recursive(size,0,0);
    }
    public static void recursive(int n,int r,int c){
        if(r == R && c == C){
            System.out.println(cnt);
            return ;
        }
        if (R < r + n && R >= r && C < c + n && C >= c)
        {
            // 1사분면 탐색
            recursive(n/2,r, c);
            // 2사분면 탐색
            recursive( n / 2,r,c + n / 2);
            // 3사분면 탐색
            recursive( n / 2,r + n / 2, c);
            // 4사분면 탐색
            recursive( n / 2,r + n / 2, c + n / 2);
        }
        else
        {
            cnt += n * n;
        }

    }
}
