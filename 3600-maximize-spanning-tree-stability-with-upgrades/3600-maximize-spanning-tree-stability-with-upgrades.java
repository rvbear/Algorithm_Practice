class Solution {
    private int find(int[] par, int x) {
        if (par[x] == x) {
            return x;
        }

        return par[x] = find(par, par[x]);
    }

    private boolean check(List<int[]> edges, int val, int req, int[] par, int k) {
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];

            if (w * 2 < val) {
                return false;
            }

            int p1 = find(par, u);
            int p2 = find(par, v);

            if (p1 == p2) {
                continue;
            }

            if (w < val) {
                if (k-- == 0) {
                    return false;
                }
            }

            par[p1] = p2;
            req--;

            if (req == 0) {
                return true;
            }
        }

        return false;
    }

    public int maxStability(int n, int[][] edges, int k) {
        int[] par = new int[n];

        for (int i = 0; i < n; i++) {
            par[i] = i;
        }

        List<int[]> optional = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minMust = Integer.MAX_VALUE;
        int mustCnt = 0;

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2], m = e[3];
            min = Math.min(min, w);
            max = Math.max(max, w);

            if (m == 1) {
                int p1 = find(par, u);
                int p2 = find(par, v);

                if (p1 == p2) {
                    return -1;
                }

                par[p1] = p2;
                minMust = Math.min(minMust, w);
                mustCnt++;
            } else {
                optional.add(e);
            }
        }

        if (mustCnt == n - 1) {
            return minMust;
        }

        Collections.sort(optional, (a, b) -> b[2] - a[2]);
        int start = min;
        int end = minMust == Integer.MAX_VALUE ? 2 * max : minMust;
        int req = n - 1 - mustCnt;
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (check(optional, mid, req, par.clone(), k)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }
}