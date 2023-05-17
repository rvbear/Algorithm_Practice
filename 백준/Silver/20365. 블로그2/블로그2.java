import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());            // 문제의 수
        char[] question = br.readLine().toCharArray();      // 문제 색상
        int count = 1;

        for(int i = 1; i < N; i++)                          // BR, RB의 경우를 모두 count
            if(question[i] != question[i-1]) count++;

        if(count == 1) count = 1;                           // count가 1인 경우
        else if(count == 2) count = 2;                      // count가 2인 경우
        else if(count % 2 == 0) count = count/2 + 1;        // count가 짝수인 경우
        else count = (count-1)/2 + 1;                       // count가 홀수인 경우

        System.out.println(count);                          // 계산한 값을 출력
        br.close();             // 입력 버퍼 스트림 닫아줌
    }
}