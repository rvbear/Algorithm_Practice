import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());            // 단어의 개수
        String[] arr = new String[N];                       // 배열을 선언

        for(int i = 0; i < N; i++)                          // 배열에 값을 저장
            arr[i] = br.readLine();

        Arrays.sort(arr, new Comparator<String>() {         // 정렬 재정의
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length())              // 문자열 길이가 같을 경우 사전순으로 정렬
                    return o1.compareTo(o2);
                return o1.length() - o2.length();           // 아니라면 문자열 길이가 짧은 순으로 정렬
            }
        });

        System.out.println(arr[0]);                         // 첫번째 값을 출력
        for(int i = 1; i < N; i++)          
            if(!arr[i].equals(arr[i-1]))                    // 중복된 값을 제외하고 출력
                System.out.println(arr[i]);

        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}