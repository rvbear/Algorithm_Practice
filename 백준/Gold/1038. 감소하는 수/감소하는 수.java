import java.io.*;
import java.util.*;

public class Main {
    private static List<Long> list = new ArrayList<>();      // 감소하는 수를 저장할 배열 생성

    public static void DFS(long num, int index) {       // num은 감소하는 수, index는 num의 자리수
        if(index > 10)          // 10자리가 넘어갈 경우 return
            return;

        list.add(num);      // 감소하는 수를 list에 저장

        // 0부터 9가 맨 앞자리일 경우 나올 수 있는 경우의 수를 재귀를 통해 구하기
        // ex) DFS(4, 1) 일 경우 재귀를 통해
        // 4, 40, 41, 410, 42, 420, 421, 4210, 43, 430, 431, 4310, 432, 4320, 4321이 list에 저장됨
        for(int i = 0; i < num % 10; i++)
            DFS((num * 10) + i, index + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());
        // 0~9를 사용하여 최대 10자리까지 만드는 경우의 수 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}의 부분집합의 개수 = 2^10 = 1024
        // 아무것도 선택하지 않는 한가지 경우를 제외 = 1023
        // 또한 0은 0번째로 감소하는 수이기 때문에 0만 선택된 한가지 경우를 제외 = 1022
        if(N > 1022) {
            System.out.println(-1);
            return;
        } else if (N <= 10) {       // N이 0~10인 경우는 0번째부터 10번째이기 때문에 별도의 계산없이 바로 N 출력
            System.out.println(N);
            return;
        }

        for(int i = 0; i < 10; i++)     // 0~9를 순서대로 DFS에 넣어줌
            DFS(i, 1);

        Collections.sort(list);         // list에 저장된 값들을 오름차순으로 정렬
        System.out.println(list.get(N));        // N번째로 저장된 값을 출력

        br.close();     // 입력 버퍼 스트림 닫기
    }
}