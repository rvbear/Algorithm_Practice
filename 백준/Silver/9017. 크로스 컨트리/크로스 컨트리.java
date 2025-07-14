import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] answer = new int[t];
        int idx = 0;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] temp = br.readLine().split(" ");
            int[] rank = new int[n];
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = Integer.parseInt(temp[i]);
            }

            Map<Integer, Integer> cnt = new HashMap<>();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                cnt.put(data[i], cnt.getOrDefault(data[i], 0) + 1);
                rank[i] = data[i];
                max = Math.max(max, data[i]);
            }

            int[] five = new int[max + 1];
            Map<Integer, Integer> score = new HashMap<>();
            Map<Integer, Integer> tmp = new HashMap<>();
            int res = 1;

            for (int r : rank) {
                if (cnt.get(r) == 6) {
                    tmp.put(r, tmp.getOrDefault(r, 0) + 1);

                    if (tmp.get(r) <= 4) {
                        score.put(r, score.getOrDefault(r, 0) + res);
                    }

                    if (tmp.get(r) == 5) {
                        five[r] = res;
                    }

                    res++;
                }
            }

            int ans = Integer.MAX_VALUE;
            int fiveScore = Integer.MAX_VALUE;
            for (Integer key : score.keySet()) {
                int value = score.get(key);
                if (value < ans) {
                    ans = value;
                    fiveScore = five[key];
                    answer[idx] = key;
                } else if (value == ans) {
                    if (fiveScore > five[key]) {
                        answer[idx] = key;
                    }
                }
            }
            idx++;
        }

        for (int a : answer) {
            System.out.println(a);
        }
    }
}
