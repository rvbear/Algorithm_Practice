import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());
        long A = Long.parseLong(stk.nextToken());           // 왼쪽 범위
        long B = Long.parseLong(stk.nextToken());           // 오른쪽 범위
        int MAX = 10000000;
        boolean[] num = new boolean[MAX+1];                 // 소수들을 저장할 배열

        for(int i = 2; i <= MAX; i++)                       // 에라토스테네스의 체를 사용하여 소수를 판별
            for(int j = i*2; j <= MAX; j+=i)
                num[j] = true;

        ArrayList<Long> list = new ArrayList<>();           // 거의 소수를 저장할 배열
        for(int i = 2; i <= MAX; i++) {
            if(B <= i) break;                               // B보다 크거나 같을 경우 반복문 빠져나옴
            if(!num[i])                                     // 소수일 경우
                for(int j = 2; ;j++) {
                    if((long)Math.pow(i, j) > B) break;     // 소수의 제곱이 B보다 크다면 빠져나옴
                    list.add((long)Math.pow(i, j));         // 작다면 배열에 저장
                }
        }

        Collections.sort(list);                             // 배열을 정렬

        int min = 0, max = list.size();                     // 이분탐색 시작
        while(min <= max) {                                 // A보다 작은 수 중에서 가장 큰 수를 저장한 인덱스를 구함
            int mid = (min + max) / 2;
            if(list.get(mid) < A) min = mid + 1;
            else max = mid - 1;
        }

        System.out.println(list.size() - min);              // (배열의 크기 - A보다 작은 크기)를 출력
        br.close();                                         // 입력 버퍼 스트림 닫아줌
    }
}