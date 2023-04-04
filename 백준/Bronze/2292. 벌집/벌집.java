import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());        // 찾아갈 방의 번호

        int count = 1, room = 1;                        // 건너갈 방의 개수, 방의 범위
        for(int i = 1; N > room; i++) {                 // 방의 번호가 범위 안에 들때까지 반복
            count++;                                    // count 1 증가
            room += 6*i;                                // 방의 범위 6의 배수만큼 증가
        }

        System.out.println(count);                      // 건너간 방의 개수 출력

        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}