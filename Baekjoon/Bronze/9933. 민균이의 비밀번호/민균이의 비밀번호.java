import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));          // 버퍼 스트림을 통해 입력
        StringBuilder stb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());        // 후보의 개수
        int size = 0;                                   // 비밀번호 글자의 길이
        char middle = ' ';                              // 비밀번호의 가운데 글자

        Map<String, String> hashMap = new HashMap<>();          // 값을 저장

        for(int i = 0; i < N; i++) {                            // N번 반복
            String temp = br.readLine();
            if(size != 0 && middle != ' ') continue;            // 값이 들어갔다면 continue
            hashMap.put(temp, temp);                            // hashmap에 저장
            stb.append(temp).reverse();                         // 값을 뒤집어줌
            if(hashMap.containsKey(stb.toString())) {           // 뒤집은 값이 hashmap에 있는지 확인
                String answer = hashMap.get(stb.toString());
                size = answer.length();
                middle = answer.charAt(answer.length()/2);
            }
            stb.setLength(0);                                   // StringBuilder 초기화
        }

        System.out.println(size + " " + middle);
        br.close();             // 입력 버퍼 스트림 닫아줌
    }
}