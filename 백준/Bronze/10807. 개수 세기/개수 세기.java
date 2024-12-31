import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk;

        int N = Integer.parseInt(br.readLine());        // 입력받을 숫자의 개수
        stk = new StringTokenizer(br.readLine());       // 숫자 입력
        int V = Integer.parseInt(br.readLine());        // 찾아낼 숫자

        int count = 0;                                  // 해당 숫자의 개수
        for(int i = 0; i < N; i++)          
            if(V == Integer.parseInt(stk.nextToken()))  // 찾아낼 숫자와 같다면 count 증가
                count++;

        System.out.println(count);                      // count 출력
        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}