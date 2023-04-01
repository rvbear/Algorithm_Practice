import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int sum = 1;
        for(int i = 0; i < 3; i++)
            sum *= Integer.parseInt(br.readLine());

        String question = String.valueOf(sum);

        int[] count = new int[10];
        for(int j = 0; j < question.length(); j++) {
            switch (question.charAt(j)){
                case '0':
                    count[0]++;
                    break;
                case '1':
                    count[1]++;
                    break;
                case '2':
                    count[2]++;
                    break;
                case '3':
                    count[3]++;
                    break;
                case '4':
                    count[4]++;
                    break;
                case '5':
                    count[5]++;
                    break;
                case '6':
                    count[6]++;
                    break;
                case '7':
                    count[7]++;
                    break;
                case '8':
                    count[8]++;
                    break;
                case '9':
                    count[9]++;
                    break;
            }
        }

        for(int k = 0; k < 10; k++)
            System.out.println(count[k]);

        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}