import java.util.*;
import java.io.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length, begin = 0;
        long max = 0, current = 0;
        Set<Integer> elements = new HashSet<>();

        for(int end = 0; end < n; end++) {
            if(!elements.contains(nums[end])) {
                current += nums[end];
                elements.add(nums[end]);

                if(end - begin + 1 == k) {
                    max = Math.max(max, current);
                    current -= nums[begin];
                    elements.remove(nums[begin]);
                    begin++;
                }
            } else {
                while(nums[begin] != nums[end]) {
                    current -= nums[begin];
                    elements.remove(nums[begin]);
                    begin++;
                }
                begin++;
            }
        }
        
        return max;
    }
}