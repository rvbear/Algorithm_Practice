import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());      // 듣도 못한 사람 수
        int M = Integer.parseInt(stk.nextToken());      // 보도 못한 사람 수

        HashMap<String, String> hashMap = new HashMap<>();      // 듣도 못한 사람을 저장할 hashmap
        ArrayList<String> arrayList = new ArrayList<>();        // 듣도 보도 못한 사람을 저장할 arrayList

        for(int i = 0; i < N+M; i++) {
            if(i < N) {                                         // i가 N보다 작을 경우 듣도 못한 사람들을 입력받아 hashmap에 저장
                String listen = br.readLine();
                hashMap.put(listen, listen);
            }
            else {                                              // i가 N보다 클 경우 보도 못한 사람들을 입력받아
                String see = br.readLine();                     // hashmap에 있는지 비교한 뒤 있다면 배열에 저장
                if(hashMap.containsKey(see))
                    arrayList.add(see);
            }
        }

        Collections.sort(arrayList);                            // 배열을 정렬
        System.out.println(arrayList.size());                   // 배열의 크기 출력
        for(int i = 0; i < arrayList.size(); i++)               // 배열에 있는 값을 출력
            System.out.println(arrayList.get(i));

        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}