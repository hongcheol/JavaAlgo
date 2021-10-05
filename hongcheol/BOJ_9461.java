import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9461 {
    static StringBuilder sb = new StringBuilder();
    static long pado[] = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 0;
        int n = 0;
        pado[1] = 1;
        pado[2] = 1;
        pado[3] = 1;
        pado[4] = 2;
        pado[5] = 2;
        pado[6] = 3;
        for(int i = 7;i<101;i++) pado[i] = pado[i-1] + pado[i-5];
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            sb.append(pado[n]);
            if(t != 0) sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
