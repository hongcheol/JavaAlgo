import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2635 {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int number = 0;
        //반절만 보면 된다.
        for(int randomNumber = n/2;randomNumber<=n;randomNumber++){
            int temp = count(n,randomNumber);
            if(cnt<temp){
                cnt = temp;
                number = randomNumber;
            }
        }
        sb.append(cnt).append("\n");
        int temp = 0;
        while(n>=0){
            sb.append(n+" ");
            temp = n;
            n = number;
            number = temp-n;
        }
        System.out.println(sb.toString());
    }
    static int count(int n,int num){
        int counter = 0;
        int temp = 0;
        while(n>=0){
            temp = n;
            n = num;
            num = temp-n;//100-62 = 38

            counter++;
        }
        return counter;
    }
}
