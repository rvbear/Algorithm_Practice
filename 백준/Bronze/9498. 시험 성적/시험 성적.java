import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int score = Integer.parseInt(br.readLine());            // 시험 점수 입력 받음

        if(score >= 90) System.out.println("A");
        else if(score >= 80) System.out.println("B");
        else if(score >= 70) System.out.println("C");
        else if(score >= 60) System.out.println("D");
        else System.out.println("F");

        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}