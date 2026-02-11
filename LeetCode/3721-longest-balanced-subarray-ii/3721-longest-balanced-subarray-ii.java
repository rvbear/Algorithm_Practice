class SegmentTree {
    public int n;
    public int[] sum, mn, mx;

    SegmentTree(int n) {
        this.n = n;
        sum = new int[4 * n];
        mn = new int[4 * n];
        mx = new int[4 * n];
    }

    void pull(int node) {
        int l = node * 2, r = node * 2 + 1;
        sum[node] = sum[l] + sum[r];
        mn[node] = Math.min(mn[l], sum[l] + mn[r]);
        mx[node] = Math.max(mx[l], sum[l] + mx[r]);
    }

    void update(int idx, int val) {
        update(1, 0, n - 1, idx, val);
    }

    void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            sum[node] = val;
            mn[node] = val;
            mx[node] = val;
            return;
        }

        int m = (l + r) / 2;
        
        if (idx <= m) {
            update(node * 2, l, m, idx, val);
        } else {
            update(node * 2 + 1, m + 1, r, idx, val);
        }

        pull(node);
    }

    boolean exist(int node, int sumBefore, int target) {
        int need = target - sumBefore;
        return mn[node] <= need && need <= mx[node];
    }

    int findRightMostPrefix(int target) {
        return findRightMostPrefix(1, 0, n - 1, 0, target);
    }

    int findRightMostPrefix(int node, int l, int r, int sumBefore, int target) {
        if (!exist(node, sumBefore, target)) {
            return - 1;
        }

        if (l == r) {
            return l;
        }

        int m = (l + r) / 2;
        int lc = node * 2, rc = node * 2 + 1;
        int sumBeforeRight = sumBefore + sum[lc];

        if (exist(rc, sumBeforeRight, target)) {
            return findRightMostPrefix(rc, m + 1, r, sumBeforeRight, target);
        }

        return findRightMostPrefix(lc, l, m, sumBefore, target);
    }
}

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length, ans = 0;

        SegmentTree stree = new SegmentTree(n);
        Map<Integer, Integer> first = new HashMap<>();

        for (int l = n - 1; l >= 0; l--) {
            int num = nums[l];

            Integer old = first.get(num);
            if (old != null) {
                stree.update(old, 0);
            }

            first.put(num, l);
            stree.update(l, ((num & 1) == 0) ? 1 : -1);

            int r = stree.findRightMostPrefix(0);
            if (r >= l) {
                ans = Math.max(ans, r - l + 1);
            }
        }

        return ans;
    }
}