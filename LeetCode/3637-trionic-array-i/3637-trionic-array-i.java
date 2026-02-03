class Solution {
    public boolean isTrionic(int[] nums) {
        int idx1 = 0, idx2 = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                idx1 = i - 1;
                break;
            }
        }

        for (int i = idx1 + 1; i < nums.length; i++) {
            if (nums[i - 1] <= nums[i]) {
                idx2 = i - 1;
                break;
            }
        }

        boolean flag = true;
        for (int i = idx2 + 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                flag = false;
                break;
            }
        }

        return idx1 != 0 && idx1 != idx2 && idx2 != nums.length && flag;
    }
}