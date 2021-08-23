import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2217_greedy {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] ropes = new int[n];
        int max = 0;
        int now = 0;
        for(int i = 0;i<n;i++){
            ropes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ropes);
        for(int i = 0;i<n;i++){
            now = ropes[i]*(n-i);
            if(max<now) max = now;
        }
        System.out.println(max);
    }
}
