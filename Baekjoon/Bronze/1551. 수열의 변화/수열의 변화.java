import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());      // 수열의 크기
        int K = Integer.parseInt(stk.nextToken());      // 반복 횟수

        stk = new StringTokenizer(br.readLine(), ",");      // ","으로 String을 분해
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i < N; i++)                                // 분해된 값을 배열에 저장
            array.add(Integer.parseInt(stk.nextToken()));

        for(int i = 0; i < K; i++) {
            ArrayList<Integer> change = new ArrayList<>();        // 새로운 배열 선언
            for(int j = 0; j < array.size() - 1; j++)             // change[a] = array[a+1] - array[a]
                change.add(array.get(j + 1) - array.get(j));
            array = change;                                       // change 배열을 array에 저장
        }

        for(int i = 0; i < array.size(); i++) {                   // ","를 사용하여 구분한 뒤 출력
            if(i == array.size() - 1)
                System.out.print(array.get(i));
            else
                System.out.print(array.get(i) + ",");
        }
        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}