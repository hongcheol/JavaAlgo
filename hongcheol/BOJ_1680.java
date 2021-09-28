import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1680 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int t = 0;t<T;t++){
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int car = 0;
            int dist = 0;
            int[][] area = new int[N][N];//거리, 쓰레기양
            for(int i = 0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                area[i][0] = Integer.parseInt(st.nextToken());
                area[i][1] = Integer.parseInt(st.nextToken());
            }
            for(int i = 0;i<N;i++){
                if(car+area[i][1]>W){
                    car = area[i][1];
                    dist += area[i][0];
                }else if(car+area[i][1]==W && i != N-1){
                    car = 0;
                    dist += area[i][0];
                }else {
                    car += area[i][1];
                }
            }
            dist += area[N-1][0];
            System.out.println(dist*2);
        }
    }
}
