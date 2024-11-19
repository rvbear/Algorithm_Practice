import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());                    // Test Case
        Integer[] price = new Integer[N];                           // 가격
        for(int i = 0; i < N; i++)
            price[i] = Integer.parseInt(br.readLine());

        Arrays.sort(price, Collections.reverseOrder());             // 오름차순 정렬

        int sum = 0;
        for(int i = 0; i < N; i++) {                                // 나머지가 2가 될때만 넘어감
            if(i%3 == 2) continue;
            sum += price[i];
        }

        System.out.println(sum);
        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}