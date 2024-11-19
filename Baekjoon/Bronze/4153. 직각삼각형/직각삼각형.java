import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));         // 버퍼 스트림을 통해 출력

        while(true) {
            String question = br.readLine();
            int[] num = new int[3];
            if(question.equals("0 0 0")) break;
            StringTokenizer stk = new StringTokenizer(question);
            for(int i = 0; i < 3; i++) num[i] = Integer.parseInt(stk.nextToken());
            Arrays.sort(num);
            if(num[2]*num[2] == num[0]*num[0] + num[1]*num[1]) bw.write("right\n");
            else bw.write("wrong\n");
        }

        br.close();         // 입력 버퍼 스트림 닫아줌
        bw.close();         // 출력 버퍼 스트림 닫아줌
    }
}