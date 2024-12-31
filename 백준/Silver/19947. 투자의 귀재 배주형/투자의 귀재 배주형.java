import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(stk.nextToken());      // 초기 비용
        int Y = Integer.parseInt(stk.nextToken());      // 투자 기간

        int[] arr = new int[Y+1];
        arr[0] = H;                                     // 초깃값 설정
        for(int i = 1; i <= Y; i++) {
            arr[i] = (int)(arr[i-1] * 1.05);            // A의 이자율을 등록
            if(i >= 3)                                  // 3년 이상 지났을 경우 B의 이자율을 넣은 값과 현재 값을 비교하여 큰 값을 저장
                arr[i] = (int) Math.max(arr[i], arr[i-3] * 1.2);
            if(i >= 5)                                  // 5년 이상 지났을 경우 C의 이자율을 넣은 값과 현재 값을 비교하여 큰 값을 저장
                arr[i] = (int) Math.max(arr[i], arr[i-5] * 1.35);
        }

        System.out.println(arr[Y]);                     // 투자 기간이 지난 뒤 선택된 가장 큰 값을 출력
        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}