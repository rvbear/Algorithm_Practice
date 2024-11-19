import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());                // n번째 영화 제목이 들어간 수
        int count = 1, num = 666;                               // 666이 들어간 숫자 카운트, 초깃값

        while(count < n) {
            if(String.valueOf(++num).contains("666")) {         // 초깃값을 증가시켜 666이 포함되었다면
                count++;                                        // 카운트 증가
            }
        }

        System.out.println(num);                                // 해당 번째 영화 제목에 들어간 수 출력
        br.close();
    }
}