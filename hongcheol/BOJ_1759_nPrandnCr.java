import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_nPrandnCr {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int l,c;
    static char[] charArray;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        //c개 중에 l개를 뽑아서 만든다.
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        charArray = new char[c];
        for(int i = 0;i<c;i++){
            charArray[i] = st.nextToken().charAt(0);
        }
        int[] p = new int[c];
        int cnt = 0;
        int vowelCnt = 0, consonantsCnt = 0;
        while(cnt++<c-l)p[c-cnt]= 1;
        Arrays.sort(charArray);
        do{
            vowelCnt = 0;
            consonantsCnt = 0;
            for(int i = 0;i<c;i++){
                //모음이면
                if(p[i] == 0) {
                    if (vowelCheck(charArray[i])) vowelCnt++;
                    else consonantsCnt++;
                }
            }
            if(vowelCnt<1 || consonantsCnt < 2) continue;
            for(int i = 0;i<c;i++){
                if(p[i] == 0){
                    sb.append(charArray[i]);
                }
            }
            sb.append("\n");

        }while(nextPerm(p));
        System.out.println(sb.toString());
    }
    static boolean nextPerm(int[] numbers){
        int i = c-1;
        while(i>0&&numbers[i-1]>=numbers[i])i--;
        if(i==0) return false;

        int j = c-1;
        while(numbers[j]<=numbers[i-1])j--;

        swap(numbers,i-1,j);

        int k = c-1;
        while(i<k){
            swap(numbers,i++,k--);
        }
        return true;
    }

    static void swap(int[] numbers,int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
    static boolean vowelCheck(char c){
        final char[] vowel = {'a','e','i','o','u'};
        for(int i = 0;i<5;i++){
            if(c == vowel[i]) return true;
        }
        return false;
    }
}
