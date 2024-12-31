import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());        // 막대기의 개수
        int[] building = new int[N];

        for(int i = N - 1; i >= 0; i--)                 // 배열에 거꾸로 저장
            building[i] = Integer.parseInt(br.readLine());

        int count = 0, high = 0;                        // 보이는 건물의 개수, 가장 높은 건물의 높이
        for(int i = 0; i < N; i++)                                 
            if(high < building[i]) {                    // 가장 높은 건물의 높이보다 높다면
                high = building[i];                     // 가장 높은 건물의 높이를 변경
                count++;                                // count를 증가
            }

        System.out.println(count);                      // count를 출력

        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}