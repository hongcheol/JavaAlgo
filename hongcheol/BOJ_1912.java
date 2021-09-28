import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912 {
    static int[] arr = new int[100001];
    static int[] input = new int[100001];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        if(n==1){
            System.out.println(input[0]);
            return ;
        }
        arr[0] = input[0];
        for(int i = 1;i<n;i++){
            if(arr[i-1]+input[i] >= input[i]) arr[i] = arr[i-1]+input[i];
            else arr[i] = input[i];
        }
        max = arr[0];
        for(int i = 0;i<n;i++){
            max = arr[i]>max ? arr[i] : max;
        }
        System.out.println(max);
    }
}
