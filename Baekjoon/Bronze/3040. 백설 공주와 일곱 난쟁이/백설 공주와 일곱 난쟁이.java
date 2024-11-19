import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        ArrayList<Integer> arrayList = new ArrayList<>();       // 모자의 수를 저장할 배열
        int sum = 0;                                            // 9개의 수의 총합

        for(int i = 0; i < 9; i++) {
            arrayList.add(Integer.parseInt(br.readLine()));     // 배열에 값을 저장
            sum += arrayList.get(i);                            // 값을 더해줌
        }

        boolean flag = false;                                   // 반복문을 빠져나오기 위한 변수
        for(int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++)
                if (sum - 100 == arrayList.get(i) + arrayList.get(j)) {     // 두 수의 합이 총합에서 100을 뺀 수랑 같다면
                    arrayList.remove(i);                        // 배열에서 제거
                    arrayList.remove(j - 1);              // 배열에서 제거(위에서 제거해줬기 때문에 index 하나 줄여줌)
                    flag = true;                                // 반복문을 빠져나오기 위해 true로 만들어줌
                    break;
                }
            if(flag) break;                                     // flag가 true라면 반복문 빠져나옴
        }

        for(int k = 0; k < arrayList.size(); k++)               // 배열에 저장된 값을 출력
            System.out.println(arrayList.get(k));

        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}