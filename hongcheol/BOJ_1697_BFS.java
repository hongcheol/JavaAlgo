import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_BFS {
    static int MAX = 100001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] array = new int[MAX];
    static int n,k;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        System.out.println(bfs());
    }
    static int bfs(){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(n);
        while(!queue.isEmpty()){
            int nowPos = queue.poll();
            if(nowPos == k) return array[nowPos];
            int[] iter = {nowPos-1,nowPos+1,nowPos*2};
            for(int i = 0;i<3;i++){
                if(iter[i]>=0 && iter[i]<MAX && array[iter[i]] == 0){

                    array[iter[i]] = array[nowPos]+1;
                    queue.offer(iter[i]);
                }
            }
        }
        return -1;
    }
}
