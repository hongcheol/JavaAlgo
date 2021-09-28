import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * DFS
 */
public class BOJ_11725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited = new boolean[100001];
    static int[] parent = new int[100001];
    static List[] tree = new List[100001];
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i = 0;i<=n;i++){
            tree[i] = new ArrayList();
        }
        for(int i = 0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()),v2 = Integer.parseInt(st.nextToken());
            tree[v1].add(v2);
            tree[v2].add(v1);
        }
        DFS(1);
        for(int i = 2;i<=n;i++){
            sb.append(parent[i]+"\n");
        }
        System.out.println(sb.toString());
    }
    public static void DFS(int start){
        visited[start] = true;
        for(int i = 0;i<tree[start].size();i++){
            int next = (int)tree[start].get(i);
            if(visited[next]) continue;
            parent[next] = start;
            DFS(next);
        }
    }
}
