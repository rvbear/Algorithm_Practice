import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());            // 레벨의 수
        int[] scores = new int[N];                          // 각 레벨의 점수
        for(int i = N-1; i >= 0; i--)                       // 거꾸로 저장
            scores[i] = Integer.parseInt(br.readLine());

        int count = 0, temp = 0;                            // 감소시켜야 하는 횟수, 임시 저장값
        for(int i = 1; i < N; i++) {
            if((scores[i-1] - 1) > scores[i]) continue;     // 이전 레벨의 점수보다 작다면 continue
            temp = scores[i-1] - 1;                         // 아니라면 이전 레벨의 점수 - 1의 값을 temp에 저장
            count += scores[i] - temp;                      // 그 후 현재 레벨의 점수에서 temp 값을 뺀 만큼 count 증가
            scores[i] = temp;                               // temp값을 현재 레벨의 점수에 저장
        }

        System.out.println(count);                          // count 출력
        br.close();                                         // 입력 버퍼 스트림 닫아줌
    }
}