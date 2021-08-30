import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2669 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int[][] field = new int[101][101];
        int lr,lc,rr,rc;
        int area = 0;
        for(int i = 0;i<4;i++){
            st = new StringTokenizer(br.readLine());
            lr = Integer.parseInt(st.nextToken());
            lc = Integer.parseInt(st.nextToken());
            rr = Integer.parseInt(st.nextToken());
            rc = Integer.parseInt(st.nextToken());
            for(int r = lr;r<rr;r++){
                for(int c = lc;c<rc;c++){
                    if(field[r][c]==0) {
                        area++;
                        field[r][c] = 1;
                    }
                }
            }
        }

        System.out.println(area);

    }
}
