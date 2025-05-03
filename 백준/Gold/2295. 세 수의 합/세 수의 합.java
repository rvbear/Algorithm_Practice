import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                set.add(arr.get(i) + arr.get(j));
            }
        }

        loop : for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (set.contains(arr.get(i) - arr.get(j))) {
                    System.out.println(arr.get(i));
                    break loop;
                }
            }
        }
    }
}
