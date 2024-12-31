import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(stk.nextToken());      // 월
        int y = Integer.parseInt(stk.nextToken());      // 일

        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};      // 요일을 저장한 배열
        int[] lastday = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};    // 각 월의 날짜를 저장한 배열

        int find = 0;                   // 찾으려는 날짜
        for(int i = 0; i < x; i++)      // 해당 월의 전까지 모든 날짜를 더함
            find += lastday[i];
        find += y;                      // 찾으려는 날짜를 더해줌

        System.out.println(days[find%7]);       // 더한 날짜를 7로 나눈 나머지가 인덱스가 됨
        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}