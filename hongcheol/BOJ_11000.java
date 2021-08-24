import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] input;
    static int[][] univ;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int classNum = 0;
        int idx = 0,now = 0;
        input = new int[n][2];
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input,(o1,o2)->o1[0]!=o2[0]?o1[0]-o2[0]:o1[1]-o2[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(input[0][1]);
        for(int i = 1;i<n;i++){
            if(pq.peek()<=input[i][0]) pq.poll();
            pq.offer(input[i][1]);
        }
        System.out.println(pq.size());
    }
}
