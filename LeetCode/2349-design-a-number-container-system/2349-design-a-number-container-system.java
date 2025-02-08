import java.util.*;

class NumberContainers {
    private Map<Integer, PriorityQueue<Integer>> res;
    private Map<Integer, Integer> idx;

    public NumberContainers() {
        res = new HashMap<>();
        idx = new HashMap<>();   
    }
    
    public void change(int index, int number) {
        if (idx.containsKey(index)) {
            int pre = idx.get(index);
            
            if (pre == number) {
                return;
            }

            res.get(pre).remove(index);
        }

        res.computeIfAbsent(number, k -> new PriorityQueue<>()).offer(index);
        idx.put(index, number);
    }
    
    public int find(int number) {
        PriorityQueue<Integer> pq = res.getOrDefault(number, new PriorityQueue<>());

        return pq.isEmpty() ? -1 : pq.peek();
    }
}
