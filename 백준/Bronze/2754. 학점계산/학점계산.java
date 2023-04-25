import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));          // 버퍼 스트림을 통해 입력

        HashMap<String, Double> hak = new HashMap<>();
        hak.put("A+", 4.3); hak.put("A0", 4.0); hak.put("A-", 3.7);
        hak.put("B+", 3.3); hak.put("B0", 3.0); hak.put("B-", 2.7);
        hak.put("C+", 2.3); hak.put("C0", 2.0); hak.put("C-", 1.7);
        hak.put("D+", 1.3); hak.put("D0", 1.0); hak.put("D-", 0.7);
        hak.put("F", 0.0);

        System.out.println(hak.get(br.readLine()));         // 입력한 학점을 키값으로 평점을 출력

        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}