import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        String room = br.readLine();                    // 방번호 입력
        int[] set = new int[10];                        // set 배열 선언
        int count = 0;                                  // count 설정

        for (int i = 0; i < room.length(); i++) {
            int num = room.charAt(i) - '0';             // 아스키 코드를 사용하여 값을 저장
            if (set[num] == 0) {                        // 사용된 적 없을 경우
                if (num == 6 && set[9] != 0) {          // 6은 사용된 적 없지만 9는 사용된 적 있을 경우
                    set[9] -= 1;
                    continue;
                } else if (num == 9 && set[6] != 0) {   // 9는 사용된 적 없지만 6은 사용된 적 있을 경우
                    set[6] -= 1;
                    continue;
                } else {                                // 모두 사용된 적 있을 경우
                    for (int j = 0; j < 10; j++)
                        set[j] += 1;
                    count++;
                    set[num] -= 1;
                }
            } else                                      // 사용된 적 있을 경우
                set[num] -= 1;
        }

        System.out.println(count);

        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}