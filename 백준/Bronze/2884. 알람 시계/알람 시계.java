import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(stk.nextToken());
        int min = Integer.parseInt(stk.nextToken());

        min -= 45;
        if(min < 0) {
            hour -= 1;
            min += 60;
        }
        if(hour < 0)
            hour = 23;

        System.out.println(hour + " " + min);

        br.close();             // 입력 버퍼 스트림 닫아줌
    }
}