import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        String question = br.readLine();        // 입력할 문자열 입력받음
        // StringBuilder를 사용
        StringBuilder line1 = new StringBuilder(".");                 // 1, 5번 라인 초기화
        StringBuilder line2 = new StringBuilder(".");                 // 2, 4번 라인 초기화
        StringBuilder line3 = new StringBuilder("#");                 // 3번 라인 초기화

        for (int i = 0; i < question.length(); i++) {                 // 문자열의 길이만큼 반복
            if((i + 1) % 3 == 0) {                                    // 3, 6, 9.. 라면 웬디 프레임 입력
                line1.append(".*..");
                line2.append("*.*.");
                line3.deleteCharAt(line3.length() - 1);
                line3.append("*.").append(question.charAt(i)).append(".*");
            }
            else {                                                     // 아니라면 피터팬 프레임 입력
                line1.append(".#..");
                line2.append("#.#.");
                line3.append(".").append(question.charAt(i)).append(".#");
            }
        }

        System.out.println(line1);        // 1번째 줄 출력
        System.out.println(line2);        // 2번째 줄 출력
        System.out.println(line3);        // 3번째 줄 출력
        System.out.println(line2);        // 4번째 줄 출력
        System.out.println(line1);        // 5번째 줄 출력

        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}