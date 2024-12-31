import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringBuilder stb = new StringBuilder();                                        // StringBuilder 사용

        boolean check = true;                       // 팰린드롬수 확인을 위한 변수 초깃값 설정
        while(true) {
            String question = br.readLine();        // 판별하기 위한 수를 입력

            if(question.equals("0")) break;        // 0이 입력될 때 반복문 종료

            for(int i = 0; i < question.length() / 2; i++)             // 크기를 반으로 나눠서 맨앞과 맨뒤부터 차례대로 확인
                if(question.charAt(i) != question.charAt(question.length() - (i + 1))) {
                    stb.append("no\n");             // 앞과 뒤가 다르다면 StringBuilder no 저장
                    check = false;                  // false로 바꿔줌
                    break;
                }

            if(check)                               // 팰린드롬수라면 StringBuilder에 yes 저장
                stb.append("yes\n");
            check = true;                           // check 변수 초기화
        }

        System.out.print(stb);          // StringBuilder에 저장된 값을 출력

        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}
