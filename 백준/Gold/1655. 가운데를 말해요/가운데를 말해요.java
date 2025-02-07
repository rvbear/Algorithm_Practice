import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (minHeap.size() == maxHeap.size()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                if (minHeap.peek() < maxHeap.peek()) {
                    int temp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(temp);
                }
            }

            stb.append(maxHeap.peek()).append("\n");
        }

        System.out.print(stb.toString());
    }
}
