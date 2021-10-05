import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static boolean[][] visited;
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        int colorCount = 0, blindCount = 0;
        char[][] map,blindMap;
        map = new char[n][];
        blindMap = new char[n][n];
        visited = new boolean[n][n];
        for(int i = 0;i<n;i++){
            map[i] = br.readLine().toCharArray();
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(map[i][j] == 'G') {
                    blindMap[i][j] = 'R';
                }else{
                    blindMap[i][j] = map[i][j];
                }
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(!visited[i][j]){
                    bfs(map,i,j);
                    colorCount++;
                }
            }
        }
        initVisited();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(!visited[i][j]){
                    bfs(blindMap,i,j);
                    blindCount++;
                }
            }
        }
        System.out.println(colorCount +" "+blindCount);
    }

    private static int bfs(char[][] map,int r,int c) {
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        visited[r][c] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0;i<4;i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(boundCheck(nr,nc) && !visited[nr][nc] && (map[r][c]==map[nr][nc])){
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return cnt;
    }

    private static boolean boundCheck(int r, int c) {
        if(r>=0 && r<n && c>=0 && c<n ) return true;
        else return false;
    }

    private static void initVisited() {
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                visited[i][j] = false;
            }
        }
    }


}
