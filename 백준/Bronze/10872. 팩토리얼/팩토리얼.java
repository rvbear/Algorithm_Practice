import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림으로 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));         // 버퍼 스트림으로 출력

        int N = Integer.parseInt(br.readLine());        // 숫자 입력

        if(N == 1 && N == 0)
            bw.write(String.valueOf(1));
        else {
            int temp = 1;
            for(int i = N; i > 0; i--)
                temp *= i;
            bw.write(String.valueOf(temp));
        }

        br.close();
        bw.close();
    }
}