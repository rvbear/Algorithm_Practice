import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        String word = br.readLine();

        int sum = 0;
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) < 97)             // 대문자라면 38을 빼줌
                sum += word.charAt(i) - 38;
            else                                // 소문자라면 96을 빼줌
                sum += word.charAt(i) - 96;
        }

        for(int i = 2; i <= (int)Math.sqrt(sum); i++)
            if(sum % i == 0) {                  // 나눠지는 수가 있을 경우 소수가 아님
                System.out.println("It is not a prime word.");
                return;
            }

        System.out.println("It is a prime word.");
        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}