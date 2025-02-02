class Solution {
    public boolean check(int[] nums) {
        int cnt = 0;
        
        if (nums[0] < nums[nums.length-1]) {
            cnt++;
        }
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > nums[i]) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
            }
        }

        return true;
    }
}