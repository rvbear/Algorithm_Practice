import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());                            // 학생의 수
        StringTokenizer stk = new StringTokenizer(br.readLine());           // StringTokenizer를 사용해 분해

        ArrayList<Integer> arrayList = new ArrayList<>();                   // 학생 순서를 담을 배열
        for(int i = 0; i < N; i++)                                          // N번 반복
            // 배열의 크기에서 뽑은 숫자를 뺀다면 원하는 위치가 나옴
            arrayList.add(arrayList.size() - Integer.parseInt(stk.nextToken()), i + 1);

        for(int i = 0; i < N; i++)                  // 배열에 저장된 값 출력
            System.out.print(arrayList.get(i) + " ");

        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}