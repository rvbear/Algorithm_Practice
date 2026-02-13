class Solution {
    private int find2(char[] c, char x, char y) {
        int n = c.length, len = 0;
        int[] first = new int[2 * n + 1];
        Arrays.fill(first, -2);

        int clearIdx = -1, diff = n;
        first[diff] = -1;

        for (int i = 0; i < n; i++) {
            if (c[i] != x && c[i] != y) {
                clearIdx = i;
                diff = n;
                first[diff] = clearIdx;
            } else {
                if (c[i] == x) {
                    diff++;
                } else {
                    diff--;
                }

                if (first[diff] < clearIdx) {
                    first[diff] = i;
                } else {
                    len = Math.max(len, i - first[diff]);
                }
            }
        }

        return len;
    }

    private int find3(char[] c) {
        long state = Long.MAX_VALUE / 2;
        Map<Long, Integer> first = new HashMap<>();
        first.put(state, -1);

        int len = 0;

        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'a') {
                state += 1000001;
            } else if (c[i] == 'b') {
                state -= 1000000;
            } else {
                state--;
            }

            if (first.containsKey(state)) {
                len = Math.max(len, i - first.get(state));
            } else {
                first.put(state, i);
            }
        }

        return len;
    }

    public int longestBalanced(String s) {
        char[] c = s.toCharArray();
        int n = c.length;

        int curA = 0, curB = 0, curC = 0;
        int maxA = 0, maxB = 0, maxC = 0;

        for (int i = 0; i < n; i++) {
            if (c[i] == 'a') {
                curA = (i > 0 && c[i - 1] == 'a') ? curA + 1 : 1;
                maxA = Math.max(maxA, curA);
            } else if (c[i] == 'b') {
                curB = (i > 0 && c[i - 1] == 'b') ? curB + 1 : 1;
                maxB = Math.max(maxB, curB);
            } else {
                curC = (i > 0 && c[i - 1] == 'c') ? curC + 1 : 1;
                maxC = Math.max(maxC, curC);
            }
        }

        int ans = Math.max(Math.max(maxA, maxB), maxC);

        ans = Math.max(ans, find2(c, 'a', 'b'));
        ans = Math.max(ans, find2(c, 'b', 'c'));
        ans = Math.max(ans, find2(c, 'c', 'a'));

        ans = Math.max(ans, find3(c));

        return ans;
    }
}