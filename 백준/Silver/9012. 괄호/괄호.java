import java.io.*;
import java.util.*;

public class Main {
    public static boolean check(String line) {      // 괄호가 제대로 닫혔는지 확인하는 함수
        Stack<Character> s = new Stack<>();         // 스택 생성
        for(int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if(c == '(') {                          // 괄호가 열렸다면 스택에 저장
                s.add(c);
                continue;
            }
            if(s.isEmpty()) {                       // 괄호를 닫으려고 하나 스택에 있는 값이 없을 경우
                return false;                       // false를 return
            }
            s.pop();                                // 스택에서 하나 제거
        }
        if(!s.isEmpty()) {                          // for문을 다 돌았음에도 불구하고 스택에 값이 남아있을 경우
            return false;                           // false를 return
        }  
        return true;                                // 제대로 완성이 됐다면 true를 return
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());        // 테스트 케이스 개수
        for(int i = 0; i < t; i++) {
            boolean flag = check(br.readLine());
            if(flag) {                                  // check 함수에서 true를 return 받았을 경우
                stb.append("YES").append("\n");
            } else {                                    // check 함수에서 false를 return 받았을 경우
                stb.append("NO").append("\n");
            }
        }

        System.out.print(stb);                          // 결과값 출력
        br.close();
    }
}