import java.util.Scanner;

/**
 * 피보나치
 */
public class BOJ_8394_DP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1) {
            System.out.println(0);
            return ;
        }
        long a1 = 2;
        long a2 = 3;
        long a3 = 0;
        if(n==2){
            System.out.println(a1);
            return;
        }
        if(n==3){
            System.out.println(a2);
            return;
        }
        for(int i = 4;i<=n;i++){
            a3 = (a2+a1)%10;
            a1 = a2%10;
            a2 = a3;
        }
        System.out.println(a3);
    }
}
