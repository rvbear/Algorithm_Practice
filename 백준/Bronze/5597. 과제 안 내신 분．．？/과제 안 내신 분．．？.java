import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        
        boolean[] students = new boolean[31];                           // 출석부
        for(int i = 0; i < 28; i++)                                     // 28명을 받아서 true로 바꿔줌
            students[Integer.parseInt(br.readLine())] = true;

        for(int i = 1; i < 31; i++)
            if(!students[i])                                            // false일 경우 출력
                System.out.println(i);
        
        br.close();             // 입력 버퍼 스트림 닫아줌
    }
}