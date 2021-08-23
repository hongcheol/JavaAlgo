import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1439 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        int zeroCnt = 0,oneCnt = 0;
        char now = input.charAt(0);
        if(now == '0') zeroCnt++;
        else oneCnt++;
        for(int i = 1;i<input.length();i++){
            if(now == input.charAt(i))continue;
            else{
                if(now == '0') oneCnt++;
                else zeroCnt++;
                now = input.charAt(i);
            }
        }
        System.out.println(Math.min(zeroCnt,oneCnt));

    }
}
