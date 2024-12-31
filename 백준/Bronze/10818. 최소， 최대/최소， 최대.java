import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());                // 입력할 값의 개수 입력
        ArrayList<Integer> arrayList = new ArrayList<>();       // 값을 저장할 배열 선언

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)                              // 값을 배열에 저장
            arrayList.add(Integer.parseInt(stk.nextToken()));

        Collections.sort(arrayList);                            // 오름차순으로 배열을 정렬

        System.out.print(arrayList.get(0) + " " + arrayList.get(N - 1));    // 맨 앞과 맨 뒤의 값을 출력
        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}