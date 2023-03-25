import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림으로 입력

        String question = (br.readLine()).toUpperCase(Locale.ROOT);         // 문자열을 모두 대문자로 바꿔서 저장
        int[] array = new int[26];     // 알파벳 개수를 크기로 int형 배열 생성

        int max = 0;                   // max값 설정
        char result = ' ';             // 결과값 설정

        for(int i = 0; i < question.length(); i++) {    // 문자열의 길이만큼 반복
            array[question.charAt(i) - 65]++;           // 인덱스를 아스키 코드로 바꿔서 배열에 값을 저장 ex) 'A' - 65 = 0
            if(max < array[question.charAt(i) - 65]) {  // 배열의 값이 max값보다 크면 max값과 result를 변경
                max = array[question.charAt(i) - 65];
                result = question.charAt(i);
            } else if (max == array[question.charAt(i) - 65])       // max값과 같다면 result를 변경
                result = '?';
        }

        System.out.println(result);                      // result에 저장된 문자를 출력
        br.close();         // 입력 버퍼 스트림을 닫아줌
    }
}