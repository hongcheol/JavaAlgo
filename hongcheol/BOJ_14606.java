import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int[] happy  = new int[11];
        int n = Integer.parseInt(br.readLine());
        happy[1] = 0;
        happy[2] = 1;
        for(int i = 3;i<=10;i++){
            if(i%2 == 0){
                happy[i] = happy[i/2]*2 + (i/2)*(i/2);
            }else{
                happy[i] = happy[i/2]+happy[i/2+1] + (i/2)*(i/2+1);
            }
        }
        System.out.println(happy[n]);
    }
}
