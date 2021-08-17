import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11728_arrayMerge {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int[] arrA = new int[n];
        int[] arrB = new int[m];
        boolean endA = false, endB = false;
        int idxA = 0, idxB = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<m;i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        while(true){
            if(idxA == n && idxB == m){
                endA = true;
                endB = true;
                break;
            }
            else if(idxA == n){
                endA = true;
                break;
            }
            else if(idxB == m){
                endB = true;
                break;
            }

            if(arrA[idxA]>arrB[idxB]){
                sb.append(arrB[idxB]+" ");
                idxB++;
            }else{
                sb.append(arrA[idxA]+" ");
                idxA++;
            }
        }
        if(!endA){
            for(;idxA<n;idxA++) sb.append(arrA[idxA]+" ");
        }
        if(!endB){
            for(;idxB<m;idxB++) sb.append(arrB[idxB]+" ");
        }
        System.out.println(sb.toString());
    }
}
