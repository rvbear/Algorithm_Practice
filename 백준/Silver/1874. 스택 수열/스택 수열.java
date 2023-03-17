import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림으로 입력
        StringBuilder stringBuilder = new StringBuilder();          // StringBuilder를 통해 출력요소 저장

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());        // 수열의 크기 입력
        int set = 0;          // 초깃값 세팅

        while(N-- > 0) {        // N번 반복
            int value = Integer.parseInt(br.readLine());        // 각 수열의 값을 입력

            if(value > set) {     // 수열의 값까지 스택에 저장
                for(int i = set + 1; i <= value; i++) {
                    stack.push(i);
                    stringBuilder.append("+").append("\n");     // StringBuilder에 "+" 저장
                }
                set = value;      // stack의 top에 저장된 값으로 설정값 변경
            }
            // stack의 top에 저장된 값이 수열의 값과 일치하지 않을 경우 만들어질 수 없는 수열이므로 "NO" 출력
            // ex) 1 2 5 3 4 일 경우 + - + - + + + - 까지 나온 뒤 3이 나와야하지만 stack의 top에 있는 수는 4이다.
            //     이럴 경우 이 수열은 만들어질 수 없기 때문에 "NO"를 출력해야한다.
            else if(stack.peek() != value) {
                System.out.println("NO");
                return;
            }

            stack.pop();        // stack의 top이 value 값이랑 같을 경우 pop을 해줌
            stringBuilder.append("-").append("\n");         // pop을 해줌과 동시에 StringBuilder에 "-" 저장
        }

        System.out.println(stringBuilder);      // 저장된 값을 출력
    }
}
