import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.List;
/**
 * 가로 세로
 * List[]로 input ArrayList[2] [0]-가로 [1]-세로
 * input받고 정렬
 * 잘린 길이 다시 저장 //2차원 배열 써서 저장 list길이만큼 할당. 가로 1번 세로 2번 자르면 [2][3]으로 할당한 후 완탐으로 면적 보면서 최대 면적 구함.
 */
public class BOJ_2628 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        List[] cut = new ArrayList[2];
        cut[0] = new ArrayList();
        cut[1] = new ArrayList();
        int num = Integer.parseInt(br.readLine());
        for(int i = 0;i<num;i++){
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            cut[pos].add(len);
        }
        int[] cutRow = new int[cut[0].size()+1];
        int[] cutCol = new int[cut[1].size()+1];
        cut[0].sort(((o1, o2) -> (int)o1-(int)o2));
        cut[1].sort(((o1, o2) -> (int)o1-(int)o2));
        int now = 0;
        for(int i = 0;i<cutRow.length-1;i++){
            int cutLine = (int)cut[0].remove(0);
            cutRow[i] = cutLine-now;
            now = cutLine;
        }
        cutRow[cutRow.length-1] = r - now;
        now = 0;
        for(int i = 0;i<cutCol.length-1;i++){
            int cutLine = (int)cut[1].remove(0);
            cutCol[i] = cutLine-now;
            now = cutLine;
        }
        cutCol[cutCol.length-1] = c - now;
        int answer = 0;
        int area = 0;
        for(int i = 0;i<cutRow.length;i++){
            for(int j = 0;j<cutCol.length;j++){
                area = cutRow[i]*cutCol[j];
                if(area>answer) answer = area;
            }
        }
        System.out.println(answer);
    }
}
