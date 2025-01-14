class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            set.add(A[i]);

            for(int j = 0; j <= i; j++) {
                if(set.contains(B[j])) {
                    res[i]++;
                }
            }
        }

        return res;
    }
}