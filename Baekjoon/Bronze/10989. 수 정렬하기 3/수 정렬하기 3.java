import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // 버퍼 스트림을 통해 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));     // 버퍼 스트림을 통해 출력

        int N = Integer.parseInt(br.readLine());        // 수의 개수를 입력

        int[] array = new int[N];   // 수를 저장할 배열 선언

        for(int i = 0; i < N; i++)        // N번만큼 반복
            array[i] = Integer.parseInt(br.readLine());

        Arrays.sort(array);

        for(int j = 0; j < N; j++) {
            bw.write(String.valueOf(array[j]));
            bw.newLine();
        }

        br.close();         // 입력 스트림 닫아줌
        bw.close();         // 출력 스트림 닫아줌
    }
}