import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringBuilder stb = new StringBuilder();     // StringBuilder를 통해 출력

        char[] array = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};         // 모음 배열 생성
        int count = 0;          // 모음의 개수 합산 변수

        while(true) {
            String sentence = br.readLine();        // 문장을 입력받음

            if(sentence.equals("#"))        // 입력받은 문장이 "#" 일 경우 반복문 종료
                break;

            // for문을 통해 sentence를 char로 나눈 뒤
            for(int i = 0; i < sentence.length(); i++) {
                char element = sentence.charAt(i);
                // 모음 배열의 요소들과 비교하여 모음이 있을 경우 count 증가
                for(int j = 0; j < array.length; j++)
                    if(element == array[j])
                        count++;
            }

            // count와 "\n"를 StringBuilder에 저장
            stb.append(count).append("\n");
            count = 0;      // count 초기화
        }

        br.close();         // 입력 버퍼 스트림 닫아줌
        System.out.print(stb);      // 저장된 StringBuilder를 출력
    }
}