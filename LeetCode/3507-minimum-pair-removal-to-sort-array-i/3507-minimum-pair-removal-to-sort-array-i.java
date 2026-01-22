import java.util.*;

class Solution {
    private int[] findToMinPair(List<Integer> arr) {
        int idx = 1, min = arr.get(0) + arr.get(1);

        for (int i = 2; i < arr.size(); i++) {
            int val = arr.get(i - 1) + arr.get(i);

            if (val < min) {
                idx = i;
                min = val;
            }
        }

        return new int[] { idx, min };
    }

    private boolean checkToSort(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < arr.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    public int minimumPairRemoval(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        
        for (int n : nums) {
            arr.add(n);
        }

        int ans = 0;
        while (!checkToSort(arr)) {
            int[] temp = findToMinPair(arr);
            arr.set(temp[0] - 1, temp[1]);
            arr.remove(temp[0]);
            ans++;
        }

        return ans;
    }
}