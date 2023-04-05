import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());        // 참여 인원

        HashMap<String, Integer> hashMap = new HashMap<>();      // 참여 인원을 저장할 HashMap
        for(int i = 0; i < N; i++) {                             // 참여 인원을 입력받아 저장
            String member = br.readLine();
            if(hashMap.containsKey(member))                      // 값이 이미 있다면 value 값 증가
                hashMap.put(member, hashMap.get(member) + 1);
            else                                                 // 값이 없다면 value 값에 1을 저장
                hashMap.put(member, 1);
        }

        for(int i = 0; i < N - 1; i++) {                        
            String finish = br.readLine();                  
            hashMap.put(finish, hashMap.get(finish) - 1);       // value 값에 1을 뺀 뒤 다시 저장
        }

        for(String key : hashMap.keySet())                      // key값을 통해 반복
            if(hashMap.get(key) != 0) {                         // value 값이 0이 아니라면 출력
                System.out.println(key);
                break;
            }

        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}