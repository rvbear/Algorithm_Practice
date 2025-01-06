class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];

        int prefixCnt = 0, prefixSum = 0;

        for(int i = 0; i < n; i++) {
            res[i] = prefixCnt * i - prefixSum;
            if(boxes.charAt(i) == '1') {
                prefixCnt++;
                prefixSum += i;
            }
        }

        int suffixCnt = 0, suffixSum = 0;

        for(int i = n-1; i >= 0; i--) {
            res[i] += suffixSum - suffixCnt * i;
            if(boxes.charAt(i) == '1') {
                suffixCnt++;
                suffixSum += i;
            }
        }

        return res;
    }
}