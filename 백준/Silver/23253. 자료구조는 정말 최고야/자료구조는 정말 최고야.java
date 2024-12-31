import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());      // 교과서의 수
        int M = Integer.parseInt(stk.nextToken());      // 교과서 더미의 수

        ArrayList<Integer> arrayList = new ArrayList<>();   // 배열 선언
        ArrayList<Integer> temp;                            // 임시 저장 배열
        boolean flag = true;

        for(int i = 0; i < M; i++) {
            int size = Integer.parseInt(br.readLine());
            stk = new StringTokenizer(br.readLine());
            if(!flag) continue;                             // No인 것이 판별된 경우 밑에를 진행하지 않고 continue;
            for(int j = 0; j < size; j++)                   // 배열에 값을 저장
                arrayList.add(Integer.parseInt(stk.nextToken()));
            temp = new ArrayList<>(arrayList);                           // 임시 저장 배열에 복사
            Collections.sort(arrayList, Collections.reverseOrder());     // 배열을 내림차순 정렬
            if(!arrayList.equals(temp))                                  // 정렬한 것과 다를 경우 flag를 false로 만들어줌
                flag = false;
            arrayList.clear();
        }

        if(!flag)
            System.out.println("No");
        else
            System.out.println("Yes");
        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}