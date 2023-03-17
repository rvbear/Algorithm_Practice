import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringBuilder stb = new StringBuilder();        // StringBuilder를 사용하여 출력

        int temp = 0;   // 변환값
        int res = 0;    // 결과값

        while(true) {
            String question = br.readLine();

            if(question.equals("#"))        // "#"을 입력받을 경우 종료
                break;
            else {
                int count = question.length();      // 제곱 계산을 위해 String의 개수를 저장
                for(int i = 0; i < question.length(); i++) {
                    // String을 charAt()을 사용하여 요소 하나씩 switch문 돌림
                    // switch문을 사용하여 각 문어기호에 값을 저장
                    switch (question.charAt(i)) {
                        case '-':
                            temp = 0; break;
                        case '\\':
                            temp = 1; break;
                        case '(':
                            temp = 2; break;
                        case '@':
                            temp = 3; break;
                        case '?':
                            temp = 4; break;
                        case '>':
                            temp = 5; break;
                        case '&':
                            temp = 6; break;
                        case '%':
                            temp = 7; break;
                        case '/':
                            temp = -1; break;
                    }
                    // 문어 숫자를 10진수로 바꿔서 계산하기
                    // 제곱의 계산은 Math.pow() 함수를 사용
                    res += temp*Math.pow(8, --count);
                }
                stb.append(res).append("\n");       // 각 문어기호의 결과값을 저장
                res = 0;        // 값 초기화
            }
        }
        System.out.print(stb);
    }
}