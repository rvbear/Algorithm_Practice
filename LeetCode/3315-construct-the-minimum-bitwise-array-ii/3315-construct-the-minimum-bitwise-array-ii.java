class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int val = nums.get(i);

            if (val != 2) {
                ans[i] = val - ((val + 1) & (-val - 1)) / 2;
            } else {
                ans[i] = -1;
            }
        }

        return ans;
    }
}