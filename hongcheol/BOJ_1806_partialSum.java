import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806_partialSum {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] partialSum;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken());
        int answer = 0;
        int idx = 0;
        st = new StringTokenizer(br.readLine());
        partialSum = new int[n];
        while(st.hasMoreTokens()){
            int nowIn = Integer.parseInt(st.nextToken());
            if(nowIn>=S) {
                answer = 1;
                break;
            }
            if(idx == 0) partialSum[idx++] = nowIn;
            else {
                partialSum[idx] = partialSum[idx-1] + nowIn;
                idx++;
            }
        }
        //System.out.println(Arrays.toString(partialSum));
        if(answer == 1){
            System.out.println(answer);
        }else if(partialSum[n-1]<S) System.out.println(0);
        else {
            //System.out.println(getAnswer(n,S));
            System.out.println(nextLength(S,n));
        }
    }
    static boolean isValid(int n,int S,int l){
        boolean valid = false;
        //System.out.println(l);
        for (int i = l-1; i < n; i++) {
            int now = partialSum[i] - partialSum[i - l + 1];
            //System.out.println("now = " + now);
            if (now >= S) {
                //System.out.println("yes!");
                valid = true;
                break;
            }
        }
        return valid;
    }
    static int nextLength(int S,int n){
        //누적합이 S보다 작은 곳은 연산해봤자 의미가 없다.
        int left = 0;
        int right = n-1;
        int mid = 0;
        int min = n;
        //0 1 2 3 4 5 6 가운데는 4로 비교하면
        //0 4 6
        while(left <= right){
            mid = (left+right)/2;
            //System.out.println(left+" "+mid+" "+right+" min>>"+min);
            if(isValid(n,S,mid)){
                //System.out.println(mid+" is valid");
                if(min>mid-1) min = mid-1;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return min;
    }
}
