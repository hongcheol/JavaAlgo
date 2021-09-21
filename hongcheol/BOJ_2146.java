import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2146 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final short[] dr = {-1,1,0,0};
    static final short[] dc = {0,0,-1,1};
    static short[][] world;
    static boolean[][] visited;
    static short n;
    static short min;
    public static void main(String[] args) throws IOException {
        n = Short.parseShort(br.readLine());
        world = new short[n][n];
        visited = new boolean[n][n];
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++){
                world[i][j] = Short.parseShort(st.nextToken());
            }
        }
        br.close();
        min = 10000;
        short number = 2;
        //섬 구분을 위해서 먼저 번호를 부여.
        for(short i = 0;i<n;i++){
            for(short j = 0;j<n;j++){
                if(world[i][j] != 0 && !visited[i][j]){
                    numberingIsland(i,j,number);
                    number++;
                }
            }
        }
        //섬의 해안가에서 다리놓기 시작bfs
        for(short i = 0;i<n;i++){
            for(short j = 0;j<n;j++){
                if(world[i][j] == 0) continue;
                for(short k = 0;k<4;k++){
                    short nr = (short) (i + dr[k]);
                    short nc = (short) (j + dc[k]);
                    if(!boundCheck(nr,nc)) continue;
                    if(world[nr][nc] == 0){
                        for(int r = 0;r<n;r++){
                            for(int c = 0;c<n;c++){
                                visited[r][c] = false;
                            }
                        }
                        short temp = bfsBridge(i,j,world[i][j]);
                        if(temp<min) min = temp;
                    }
                }
            }
        }
        System.out.println(min);
    }
//    public static void initVisited(){
//        for(int i = 0;i<n;i++){
//            for(int j = 0;j<n;j++){
//                visited[i][j] = false;
//            }
//        }
//    }
    public static short bfsBridge(short r,short c,short num){
        short len = 0;
        Queue<short[]> queue = new LinkedList<>();
        queue.offer(new short[]{r,c,len});
        short[] cur = null;
        while(!queue.isEmpty()){
            cur = queue.poll();
            if(cur[2]>min) return 9999;
            for(int i = 0;i<4;i++){
                short nr = (short) (cur[0] + dr[i]);
                short nc = (short) (cur[1] + dc[i]);
                if(boundCheck(nr,nc) && !visited[nr][nc]){
                    if(world[nr][nc] == num) continue;
                    else if(world[nr][nc] != 0 && world[nr][nc] != num){
                        return cur[2];
                    }
                    else{
                        visited[nr][nc] = true;
                        queue.offer(new short[]{nr,nc, (short) (cur[2]+1)});
                    }

                }
            }
        }
        return 9999;
    }
    public static void numberingIsland(short r,short c,short number){
        Stack<short[]> stack = new Stack<>();
        stack.push(new short[]{r,c});
        short[] cur = null;
        while(!stack.isEmpty()) {
            cur = stack.pop();
            world[cur[0]][cur[1]] = number;
            for (short i = 0; i < 4; i++) {
                short nr = (short) (cur[0] + dr[i]);
                short nc = (short) (cur[1] + dc[i]);
                if (!boundCheck(nr, nc)) continue;
                if (world[nr][nc] != 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    stack.push(new short[]{nr,nc});
                }
            }
        }
    }
    public static boolean boundCheck(short r,short c){
        if(r<0 || c < 0 || r >= n || c >= n){
            return false;
        }
        return true;
    }
}
