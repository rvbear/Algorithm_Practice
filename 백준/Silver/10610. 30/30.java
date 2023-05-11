import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력

        String N = br.readLine();                               // N값 입력 받음
        boolean flag = false;                                   // 0의 유무 판별
        int[] num = new int[N.length()];                        // 값을 저장할 배열
        int sum = 0;                                            // 모든 자릿수의 합
        for(int i = 0; i < N.length(); i++) {                   // 값을 배열에 저장하고 0이라면 true로 변환, sum에 값 더해줌
            num[i] = N.charAt(i) - '0';
            if(num[i] == 0) flag = true;
            sum += num[i];
        }

        if(!flag || sum % 3 != 0) System.out.println(-1);        // 0이 없거나 3으로 나누어 떨어지지 않는다면 -1
        else {
            Arrays.sort(num);                                    // 내림차순으로 정렬
            for (int i = N.length() - 1; i >= 0; i--)            // 배열의 뒷자리부터 출력
                System.out.print(num[i]);
        }

        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}