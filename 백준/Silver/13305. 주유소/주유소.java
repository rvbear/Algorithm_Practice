import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] temp = br.readLine().split(" ");
        long[] road = new long[n - 1];
        for (int i = 0; i < n - 1; i++) {
            road[i] = Long.parseLong(temp[i]);
        }

        temp = br.readLine().split(" ");
        long[] price = new long[n];
        for (int i = 0; i < n; i++) {
            price[i] = Long.parseLong(temp[i]);
        }

        long sum = 0;
        long minPrice = price[0];

        for (int i = 0; i < n - 1; i++) {
            if (price[i] < minPrice) {
                minPrice = price[i];
            }

            sum += (minPrice * road[i]);
        }

        System.out.println(sum);
    }
}
