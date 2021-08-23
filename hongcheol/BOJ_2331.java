import java.util.Scanner;

public class BOJ_2331 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int p = sc.nextInt();
        int cnt = 0;
        int now = A;
        boolean phaseTwo = false;
        boolean[] array = new boolean[236197];//9^5 *4
        int temp = 0;
        while(true){
            if(phaseTwo) {
                if(!array[now]) break;
                else{
                    array[now] = false;
                    temp = 0;
                    while(now>0){
                        temp += Math.pow(now%10,p);
                        now /=10;
                    }
                    now = temp;
                }
            }else{
                if(array[now]) {
                    phaseTwo = true;
                    continue;
                }
                else array[now] = true;
                temp = 0;
                while(now>0){
                    temp += Math.pow(now%10,p);
                    now /=10;
                }
                now = temp;
            }
        }
        for(int i = 1;i<236197;i++){
            if(array[i]) cnt++;
        }
        System.out.println(cnt);
    }
}
