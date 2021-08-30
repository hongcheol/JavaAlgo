import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * input받고 index순으로 정
 * 최댓값 변화 있을 때까지 다음 기둥과 비교
 * 변화 생기면
 * area += (now max index - 기존 max index)*max;
 * max = now;
 * cnt = 0;
 *
 * input - index height
 */
public class BOJ_2304 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] fence = new int[n][];
        Stack<Node> stack = new Stack<>();
        Stack<Node> rightStack = new Stack<>();
        int area = 0;
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            fence[i] = new int[]{idx,height};
        }
        Arrays.sort(fence,(o1,o2)->o1[0]-o2[0]);
        Node top = new Node(fence[0][0],fence[0][1]);
        stack.push(top);
        for(int i = 1;i<n-1;i++){
            if(top.h < fence[i][1]){
                top = new Node(fence[i][0],fence[i][1]);
                stack.push(top);
            }
        }
        Node end = new Node(fence[n-1][0],fence[n-1][1]);
        //끝에서 top까지 다시 넣기
//        for(int i = n-1;i>top.id;i--){
//
//        }
        rightStack.push(end);
        for(int i = n-2;i>stack.size()-1;i--){
            if(end.h < fence[i][1]){
                end = new Node(fence[i][0],fence[i][1]);
                rightStack.push(end);
            }
        }
        rightStack.push(top);
        area += stack.pop().h;
        while(!stack.isEmpty()){
            int temp = top.id;
            top = stack.pop();
            area += (temp-top.id)*top.h;
        }
        int temp = rightStack.pop().id;
        while(!rightStack.isEmpty()){
            end = rightStack.pop();
            area += (end.id-temp)*end.h;
            temp = end.id;
        }
        System.out.println(area);
    }
    static class Node{
        int id;
        int h;

        public Node(int id, int h) {
            this.id = id;
            this.h = h;
        }
    }
}
