class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        if(n < 2) {
            return 1;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] degree = new int[n];

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        long[] val = new long[n];
        for(int i = 0; i < n; i++) {
            val[i] = values[i];
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(degree[i] == 1) {
                q.add(i);
            }
        }

        int cnt = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            degree[cur]--;
            long carry = 0;

            if(val[cur] % k == 0) {
                cnt++;
            } else {
                carry = val[cur];
            }

            for(int temp : graph.get(cur)) {
                if(degree[temp] == 0) {
                    continue;
                }

                degree[temp]--;
                val[temp] += carry;
                if(degree[temp] == 1) {
                    q.add(temp);
                }
            }
        }

        return cnt;
    }
}