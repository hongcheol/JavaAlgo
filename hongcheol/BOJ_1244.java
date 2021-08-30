import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 스위치 개수
 * 각 스위치의 상태 on 1 off 0
 * 학생 수
 * 이어서 성별, 받은 수
 * 남 -> 성별 배수 스위치 바꾸기
 * 여 -> 대칭구간 찾아서 바꾸기
 *
 */
public class BOJ_1244 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        boolean[] switchStatus = new boolean[num];
        st = new StringTokenizer(br.readLine());
        char temp;
        for(int i = 0;i<num;i++){
            temp = st.nextToken().charAt(0);
            if(temp == '0') switchStatus[i] = false;
            else switchStatus[i] = true;
        }
        int studentNumber = Integer.parseInt(br.readLine());
        for(int i = 0;i<studentNumber;i++){
            st = new StringTokenizer(br.readLine());
            char gender = st.nextToken().charAt(0);
            int myNum = Integer.parseInt(st.nextToken());
            if(gender=='1'){
                for(int j = myNum-1;j<num;j+=myNum){
                    switchStatus[j] = !switchStatus[j];
                }
            }//남자
            else if(gender == '2'){
                int left = myNum-1,right = myNum-1;
                while(left>=0 && right <num){
                    if(switchStatus[left]!= switchStatus[right]) break;
                    left--;
                    right++;
                }
                for(int j = left+1;j<right;j++){
                    switchStatus[j] = !switchStatus[j];
                }
            }//여자
        }
        for(int i = 0;i<num;i++){
            if(i!=0 && i%20 == 0) sb.append("\n");
            if(switchStatus[i]) sb.append(1).append(" ");
            else sb.append(0).append(" ");

        }
        System.out.println(sb.toString());

    }
}
