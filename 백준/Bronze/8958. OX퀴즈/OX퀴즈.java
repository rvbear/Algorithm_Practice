import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringBuilder stb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());                // 답안의 개수 입력

        int count = 0; int sum = 0;                             // O의 카운트, 카운트의 합
        for(int i = 0; i < N; i++) {
            String answer = br.readLine();
            for(int j = 0; j < answer.length(); j++) {
                if(answer.charAt(j) == 'X') {                   // 답이 X라면 count 초기화 후 반복문 돌림
                    count = 0; continue;
                }
                count++; sum += count;                          // 답이 O라면 count 증가하고 sum에 값을 더해줌
            }
            stb.append(sum).append("\n");
            count = 0; sum = 0;                                 // count와 sum 초기화
        }

        System.out.print(stb);
        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}