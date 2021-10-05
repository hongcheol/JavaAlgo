import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1016 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken()),max = Long.parseLong(st.nextToken());
        boolean[] isJaegop = new boolean[1000001];//1000000000000이므로 1000000까지만 체크하면 된다.
        boolean[] jaegopOO = new boolean[1000001];//제곱이면 true, 제곱 ㄴㄴ이면 false;
        long answer = max - min + 1;
        for(long i = 2;i*i<=max;i++){
            if(jaegopOO[(int)i])continue;
            long jaegop = i*i;
            long j = min % jaegop == 0 ? min/jaegop : (min/jaegop)+1;
            for(; j*jaegop<=max;j++){
                if(!isJaegop[(int)((j*jaegop)-min)]){
                    isJaegop[(int)((j*jaegop)-min)] = true;
                    --answer;
                }
            }
        }
        System.out.println(answer);
    }
}
