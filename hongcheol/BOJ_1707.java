import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1707 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int V,E;
    static Map<Integer, ArrayList<Integer>> graph;
    static int[] nodeColor;
    static boolean avail;
    public static void main(String[] args) throws IOException {
        int testcase = Integer.parseInt(br.readLine());
        for(int t = 0;t<testcase;t++){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            if(V==1 && E==1) {
                sb.append("YES").append("\n");
                continue;
            }
            graph = new HashMap<>();
            for(int i = 0;i<V;i++){
                graph.put(i+1,new ArrayList<>());
            }
            avail = true;
            for(int i = 0;i<E;i++){
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken()),n2 = Integer.parseInt(st.nextToken());
                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
            }

            nodeColor = new int[V + 1];
            for(int i = 1;i<V+1;i++){
                if(nodeColor[i] == 0){
                    nodeColor[i] = 1;
                    if(!bfs(i)) avail = false;
                }
            }
            if(avail)sb.append("YES"+"\n");
            else sb.append("NO"+"\n");

        }
        System.out.println(sb.toString());
    }
    public static boolean bfs(int startNode) {

        Queue<Integer> needVisit = new LinkedList<>();
        needVisit.add(startNode);
        nodeColor[startNode] = 1;
        while (!needVisit.isEmpty()) {
            int node = needVisit.poll();
            ArrayList<Integer> temp = graph.get(node);
            for (int data : temp) {
                if (nodeColor[data] == 0) {
                    nodeColor[data] = nodeColor[node] + 1;
                    needVisit.add(data);
                } else {
                    if (nodeColor[data] % 2 == nodeColor[node] % 2) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
