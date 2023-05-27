import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(stk.nextToken());      // x값 입력
        int y = Integer.parseInt(stk.nextToken());      // y값 입력
        int w = Integer.parseInt(stk.nextToken());      // w값 입력
        int h = Integer.parseInt(stk.nextToken());      // h값 입력
        int min = x > y ? y : x;                        // x, y 비교해서 x가 크면 y값을 작다면 x값을 min값에 저장

        if(min > w-x) min = w-x;                        // w와 가깝다면 min 값에 저장
        if(min > h-y) min = h-y;                        // h와 가깝다면 min 값에 저장

        System.out.println(min);
        br.close();             // 입력 버퍼 스트림 닫아줌
    }
}