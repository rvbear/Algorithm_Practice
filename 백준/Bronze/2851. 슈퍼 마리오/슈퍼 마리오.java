import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력

        int sum = 0, temp = 0;
        boolean flag = false;
        for(int i = 0; i < 10; i++) {                                       // 10번 반복
            temp = Integer.parseInt(br.readLine());                         // temp에 값을 저장
            if(flag) continue;
            sum += temp;                                                    // sum에 더해줌
            if(sum > 100 && ((sum - 100) > (100 - (sum - temp)))) {         // sum의 값이 100보다 클 때 100과 가까운 값을 선택
                sum -= temp;
                flag = true;
            }
        }

        System.out.println(sum);
        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}