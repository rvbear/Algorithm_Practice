import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        HashSet<String> chatlog = new HashSet<>();          // 채팅 기록

        int N = Integer.parseInt(br.readLine());            // 채팅 개수
        String enter = br.readLine();
        int count = 0;                                      // 곰곰티콘 개수
        for(int i = 1; i < N; i++) {
            String people = br.readLine();                  // 사람 입력
            if(people.equals(enter)) {                      // ENTER가 입력될 경우 이전 기록 삭제 후 continue
                chatlog.clear();
                continue;
            }
            if(chatlog.contains(people)) continue;     // 이미 들어와 있는 사람일 경우 continue
            chatlog.add(people);                       // 아니라면 chatlog에 값을 넣고 count 증가
            count++;
        }

        System.out.println(count);                          // count값 출력
        br.close();             // 입력 버퍼 스트림 닫아줌
    }
}