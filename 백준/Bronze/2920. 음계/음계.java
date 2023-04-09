import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        String question = br.readLine();
        if(question.equals("1 2 3 4 5 6 7 8"))          // 순서대로라면 ascending 출력
            System.out.println("ascending");
        else if(question.equals("8 7 6 5 4 3 2 1"))     // 역순이라면 descending 출력
            System.out.println("descending");
        else                                            // 둘 다 아니라면 mixed 출력
            System.out.println("mixed");

        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}