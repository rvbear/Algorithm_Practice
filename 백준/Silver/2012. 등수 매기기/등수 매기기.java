import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());            // N명의 학생
        int[] students = new int[N];                        // 각 학생의 예상 등수
        for(int i = 0; i < N; i++)
            students[i] = Integer.parseInt(br.readLine());

        Arrays.sort(students);                              // 오름차순 정렬
        
        long angry = 0;
        for(int i = 0; i < N; i++)                          // 정렬된 등수와 각 등수의 차이의 절대값을 더해줌
            angry += Math.abs(i+1 - students[i]);

        System.out.println(angry);                          // 값을 출력
        br.close();                                         // 입력 버퍼 스트림 닫아줌
    }
}