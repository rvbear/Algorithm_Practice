import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // 버퍼 스트림을 통해 입력
        StringBuilder stb = new StringBuilder();
        StringTokenizer stk;

        int N = Integer.parseInt(br.readLine());            // 전체 케이스 개수
        ArrayList<String> arrayList = new ArrayList<>();    // 값을 저장할 배열 선언

        for(int i = 0; i < N; i++) {                        // N번 반복
            stk = new StringTokenizer(br.readLine());
            while(stk.hasMoreTokens())                      // Token들을 배열에 저장
                arrayList.add(stk.nextToken());
            stb.append("Case #").append(i+1).append(": ");
            for(int j = arrayList.size() - 1; j >= 0; j--)  // 배열을 거꾸로 StringBuilder에 저장
                stb.append(arrayList.get(j)).append(" ");
            stb.append("\n");
            arrayList.clear();                              // 배열 초기화
        }

        System.out.print(stb);
        br.close();         // 입력 스트림 닫아줌
    }
}