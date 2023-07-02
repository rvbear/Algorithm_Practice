import java.io.*;

public class Main {
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        String word = br.readLine();

        result = new int[26];
        for(int i = 0; i < 26; i++) result[i] = -1;

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(result[ch - 'a'] == -1)
                result[ch - 'a'] = i;
        }

        for(int val : result)
            System.out.print(val + " ");

        br.close();             // 입력 버퍼 스트림 닫아줌
    }
}