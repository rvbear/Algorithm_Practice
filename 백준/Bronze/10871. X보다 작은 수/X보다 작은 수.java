import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());
        StringBuilder stb = new StringBuilder();

        int N = Integer.parseInt(stk.nextToken());      // 수열의 개수
        int X = Integer.parseInt(stk.nextToken());      // 기준이 되는 수

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(stk.nextToken());
            if(X > num)                                 // X보다 작은 경우 StringBuilder에 저장
                stb.append(num).append(" ");
        }
        
        System.out.print(stb);
        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}