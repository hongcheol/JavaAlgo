import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. 블록 선택
 * 크기가 가장 큰 블록
 * 여러개면 무지개 블록의 수가 가장 많은 블록
 * 그래도 여러개면 기준 블록의 행이 가장 큰 것 //이 2개는 좌상단부터 우하단으로 탐색하면서 해결.
 * 그것마저도 여러개면 열이 가장 큰 것 선택
 * 2. 제거
 * 3. 중력
 * 4. 반시계 90도 회전
 * 5. 중력
 * 6. 터트릴 수 있는게 없을 때까지 1-5반복
 */
public class BOJ_21609 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,m;
    static int[][] field;
    static List<int[]> blocks;
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};
    static final int BLACK = -1, EMPTY = -2;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        field = new int[n][n];
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++){
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(autoGame()) {
            //중력
            gravity();
            //회전
            field = rotate();
            //중력
            gravity();
        }
        System.out.println(count);
    }
    public static boolean autoGame(){
        boolean avail = false;
        int[] init = new int[]{0,0};//0: 블록 크기, 1: 무지개 블록 수.
        List<int[]> deleteList = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        for(int r = 0;r<n;r++){
            for(int c = 0;c<n;c++){
                if(field[r][c] < 0) continue;
                if(field[r][c] == 0 || visited[r][c]) continue;
                int[] temp = blockPopBFS(r,c,visited);
                if(temp[0]<2) continue;//2보다 작으면 안터진다.
                if(init[0] <= temp[0]) {
                    if (init[0] == temp[0] && init[1] > temp[1]) continue;
                    init = temp;
                    deleteList = blocks;
                    avail = true;
                }
            }
        }
        if(!avail) return false;
        else{
            int cnt = 0;
            for(int[] data : deleteList){
                cnt++;
                field[data[0]][data[1]] = EMPTY;
            }
            count += cnt*cnt;
            return true;
        }
    }
    public static void printArr(int[][] field){
        for(int[] row : field){
            for(int data : row){
                System.out.print(data+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    //bfs
    public static int[] blockPopBFS(int r,int c,boolean[][] checked){
        int[] blockInfo = new int[]{1,0};
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        blocks = new ArrayList<>();
        blocks.add(new int[]{r,c});
        visited[r][c] = true;
        checked[r][c] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0;i<4;i++){
                int nr = cur[0]+dr[i];
                int nc = cur[1]+dc[i];
                if(!boundCheck(nr,nc) || visited[nr][nc]) continue;
                if(field[nr][nc] == field[r][c] || field[nr][nc] == 0){
                    blockInfo[0]++;//block갯수 증가
                    if(field[nr][nc] == 0) blockInfo[1]++;
                    else checked[nr][nc] = true;
                    int[] next = new int[]{nr,nc};
                    q.add(next);
                    visited[nr][nc] = true;
                    blocks.add(next);
                }
            }
        }
        return blockInfo;
    }
    public static boolean boundCheck(int r,int c){
        if(r<0 || c < 0 || r >= n || c >= n){
            return false;
        }
        return true;
    }
    //반시계 회전.
    public static int[][] rotate(){
        int[][] returnArr = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                returnArr[i][j] = field[j][n-1-i];
            }
        }
        return returnArr;
    }
    //중력
    public static void gravity(){
        for(int c = 0;c<n;c++){
            int endPoint = n-1;
            for(int r = n-1;r>=0;r--){
                if(field[r][c] == EMPTY) continue;
                else if(field[r][c] == BLACK) endPoint = r - 1;
                else{
                    int temp = field[r][c];
                    field[r][c] = EMPTY;
                    field[endPoint--][c] = temp;
                }
            }
        }
    }
}
