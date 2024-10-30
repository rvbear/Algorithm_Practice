import java.util.*;

class Solution {
    public int dfs(int remain, int[][] wait, int depth, int k) {
        if(depth > k) return 0;
        int sum = 100000000;
        
        for(int i = 1; i <= remain; i++) {
            sum = Math.min(dfs(remain-i+1, wait, depth+1, k) + wait[depth][i], sum);
        }
        
        return sum;
    }
    
    public int solution(int k, int n, int[][] reqs) {
        List<List<int[]>> list = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        for(int[] req : reqs) {
            list.get(req[2]).add(new int[] {req[0], req[1]});
        }
        
        int[][] sum = new int[k+1][n-k+2];
        for(int i = 1; i <= k; i++) {
            for(int j = 1; j <= n-k+1; j++) {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                for(int[] arr : list.get(i)) {
                    if(pq.size() < j) {
                        pq.add(arr[0] + arr[1]);
                    } else {
                        int min = pq.poll();
                        int wait = min - arr[0];
                        if(wait > 0) {
                            sum[i][j] += wait;
                            pq.add(min + arr[1]);
                        } else {
                            pq.add(arr[0] + arr[1]);
                        }
                    }
                }
            }
        }
        
        return dfs(n-k+1, sum, 1, k);
    }
}