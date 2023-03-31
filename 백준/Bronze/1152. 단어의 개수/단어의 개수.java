import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림으로 입력
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));     // 버퍼 스트림으로 출력

        String text = br.readLine();
        int count = 0;      // 단어의 개수

        StringTokenizer stk = new StringTokenizer(text, " ");
        while(stk.hasMoreTokens()) {
            String token = stk.nextToken();
            count++;
        }

        br.close();

        wr.write(String.valueOf(count));
        wr.flush();
        wr.close();
    }
}