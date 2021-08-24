import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_11576 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()),B=Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        long num = 0L;
        Stack<Long> stack = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for(int i = n-1;i>=0;i--){
            num += Math.pow(A,i)*Long.parseLong(st.nextToken());
        }
        while(num!=0){
            stack.push(num%B);
            num /=B;
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
