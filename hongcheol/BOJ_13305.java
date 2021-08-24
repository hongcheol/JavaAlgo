import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] distance = new int[100001];
    static int[] city = new int[100001];
    static long price = 0;
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n-1;i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            city[i] = Integer.parseInt(st.nextToken());
        }
        for(int i =1;i<n;i++){
            if(city[i-1]<city[i]) city[i] = city[i-1];
            price += (long)distance[i-1]*city[i-1];
        }
        System.out.println(price);
    }
}
