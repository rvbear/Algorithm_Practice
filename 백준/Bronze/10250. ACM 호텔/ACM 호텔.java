import java.io.*;
import java.util.StringTokenizer;

class Hotel {
    private int high;
    private int weight;
    private int customer;

    public Hotel(int array[]) {
        high = array[0];
        weight = array[1];
        customer = array[2];
    }

    public int Room_number() {
        int a = customer % high;
        int b = customer / high + 1;

        if(a == 0) {
            a = high;
            b--;
        }

        return 100 * a + b;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림으로 입력받기
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));     // 버퍼 스트림으로 출력하기

        String test = br.readLine();
        int number = Integer.parseInt(test);

        Hotel hotel[] = new Hotel[number];

        int array[] = new int[3];

        for(int i = 0; i < number; i++) {
            String data = br.readLine();
            StringTokenizer stk = new StringTokenizer(data, " ");
            int j = 0;
            while(stk.hasMoreTokens()) {
                String token = stk.nextToken();
                array[j++] = Integer.parseInt(token);
            }
            hotel[i] = new Hotel(array);
        }

        br.close();     // 입력 스트림 닫기

        for(int i = 0; i < number; i++) {
            int room_number = hotel[i].Room_number();
            wr.write(String.valueOf(room_number));
            wr.newLine();
        }

        wr.flush();
        wr.close();
    }
}