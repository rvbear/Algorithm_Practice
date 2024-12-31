import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));         // 버퍼 스트림을 통해 출력

        int K = Integer.parseInt(br.readLine());
        int size = 0;                                   // 초콜릿 크기

        for(int i = 0; ;i++)
            if(K <= Math.pow(2, i)) {                   // 2의 배수 중 K보다 크거나 같은 경우를 저장
                size = (int) Math.pow(2, i);
                break;
            }
        bw.write(String.valueOf(size) + " ");

        int count = 0;                                  // 쪼갠 개수
        for(int i = 0; ;i++) {
            if(K == size) break;                        // 처음부터 쪼갤 필요가 없을 경우
            if(K == 0) break;                           // 더이상 쪼갤 필요가 없을 경우
            else {                                      // 크기 절반 나눈 뒤 K에서 빠짐
                size /= 2;
                count++;
                if(K >= size)                         
                    K -= size;
            }
        }

        bw.write(String.valueOf(count));
        br.close();             // 입력 버퍼 스트림 닫아줌
        bw.close();             // 출력 버퍼 스트림 닫아줌
    }
}