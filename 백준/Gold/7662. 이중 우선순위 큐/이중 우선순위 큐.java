import java.io.*;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();

            for(int j = 0; j < k; j++) {
                String[] order = br.readLine().split(" ");
                int value = Integer.parseInt(order[1]);

                if(order[0].equals("I")) {
                    map.put(value, map.getOrDefault(value, 0) + 1);
                } else {
                    if(map.size() == 0) {
                        continue;
                    }

                    int key;
                    if(value == 1) {
                        key = map.lastKey();
                    } else {
                        key = map.firstKey();
                    }

                    if(map.put(key, map.get(key) - 1) == 1) {
                        map.remove(key);
                    }
                }
            }

            if(map.size() == 0) {
                bw.write("EMPTY\n");
            } else {
                bw.write(map.lastKey() + " " + map.firstKey() + "\n");
            }
        }

        br.close();
        bw.close();
    }
}