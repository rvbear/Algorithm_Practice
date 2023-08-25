import java.io.*;
import java.util.*;

class Human implements Comparable<Human> {          // 사람 클래스
    int age;                                        // 나이
    String name;                                    // 이름

    public Human(int _age, String _name) {
        age = _age; name = _name;
    }

    @Override
    public int compareTo(Human h) {                 // 나이를 기준으로 오름차순 정렬
        return age - h.age;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 사람의 수
        Human[] arr = new Human[n];                 // 사람의 수만큼 배열 생성
        for(int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            arr[i] = new Human(Integer.parseInt(stk.nextToken()), stk.nextToken());
        }

        Arrays.sort(arr);                           // 배열을 정렬

        for(Human h : arr) {                        // 정렬한 배열 순서대로 출력
            System.out.println(h.age + " " + h.name);
        }
        br.close();
    }
}