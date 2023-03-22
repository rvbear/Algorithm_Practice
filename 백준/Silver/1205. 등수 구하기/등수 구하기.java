import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림으로 입력

        StringTokenizer stk = new StringTokenizer(br.readLine());       // StringTokenizer를 사용하여 분해
        int N = Integer.parseInt(stk.nextToken());                      // 랭킹 리스트에 있는 점수의 개수
        int score = Integer.parseInt(stk.nextToken());                  // 새로운 점수
        int P = Integer.parseInt(stk.nextToken());                      // 랭킹 리스트에 올라갈 수 있는 점수의 개수

        if(N == 0) {                    // 랭킹에 있는 점수가 없을 경우 점수에 상관없이 무조건 1등이기 때문에
            System.out.println(1);      // 1을 출력 후 return
            return;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();           // 점수들을 저장할 배열
        stk = new StringTokenizer(br.readLine());                   // StringTokenizer를 사용하여 분해
        while(stk.hasMoreTokens())                                  // 남은 토큰이 없을 때까지 반복
            arrayList.add(Integer.parseInt(stk.nextToken()));       // int형으로 변환하여 배열에 저장

        arrayList.add(score);                           // 배열에 새로운 점수를 저장
        arrayList.sort(Comparator.reverseOrder());      // 내림차순으로 정렬

        if(N < P)               // 랭킹에 점수가 다 채워지지 않은 경우
            System.out.println(arrayList.indexOf(score) + 1);               // 그 점수의 랭킹을 출력
        else {                  // 랭킹에 점수가 다 채워진 경우
            if (arrayList.indexOf(score) >= P)       // 랭킹 리스트에 올라갈 수 있는 점수의 개수를 넘어가면
                System.out.println(-1);              // -1 출력
            // score 점수가 랭킹 마지막 점수와 그 다음 점수와 동일할 때 -1 출력
            else if(arrayList.get(P-1) == score && arrayList.get(P) == score)
                System.out.println(-1);
            else                                                                // 아니라면
                System.out.println(arrayList.indexOf(score) + 1);               // 그 점수의 랭킹을 출력
        }
        br.close();             // 입력 버퍼 스트림 닫아줌
    }
}