import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());                // 책의 개수
        int[] arr = new int[n];                                 // 책의 순서를 저장할 배열

        int max = n;                                            // 가장 큰 책의 번호
        int max_index = 0;                                      // 가장 큰 책의 번호가 들어간 인덱스 위치
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] == n) {                                   // 가장 큰 책의 번호를 입력 받았다면
                max_index = i;                                  // 그 위치를 저장
            }
        }

        int len = 1;                                            // 감소하는 수의 길이
        for(int i = max_index; i >= 0; i--) {                   // 가장 큰 책의 번호부터 감소하며 탐색
            if(arr[i] == max-1) {                               // 최댓값보다 하나 작은 수가 존재한다면
                max--;                                          // 최댓값을 감소시키고 길이를 증가
                len++;
            }
        }

        bw.write(String.valueOf(n-len));                      // 책의 개수 중 감소하는 길이를 빼면 재구성해서 사전 순으로 정렬가능한 카운트가 됨
        br.close(); bw.close();
    }
}