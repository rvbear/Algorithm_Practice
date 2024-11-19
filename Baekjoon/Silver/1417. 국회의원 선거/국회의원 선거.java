import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());        // 후보의 수

        int dasom = Integer.parseInt(br.readLine());        // 다솜이의 값
        ArrayList<Integer> arrayList = new ArrayList<>();   // 다른 사람들의 특표수 저장
        for(int i = 1; i < N; i++)
            arrayList.add(Integer.parseInt(br.readLine()));

        if(N == 1) {
            System.out.println(0);
            return;
        }
        int count = 0;
        Collections.sort(arrayList);                        // 배열을 정렬
        while(dasom <= arrayList.get(arrayList.size() - 1)) {   // 다솜이의 득표수가 가장 높은 득표수보다 클 경우 break
            dasom += 1;                                         // 다솜이의 득표수 증가
            count++;                                            // count 증가
            arrayList.add(arrayList.remove(arrayList.size() - 1) - 1);     // 배열의 마지막 인덱스의 값에서 1을 뺀 값을 저장
            Collections.sort(arrayList);                                         // 배열 다시 정렬
        }

        System.out.println(count);
        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}