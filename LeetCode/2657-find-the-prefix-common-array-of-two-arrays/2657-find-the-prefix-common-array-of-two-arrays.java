class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length, temp = 0;
        int[] freq = new int[n+1];
        int[] res = new int[n];

        for(int i = 0; i < n; i++) {
            if(++freq[A[i]] == 2) {
                temp++;
            }
            if(++freq[B[i]] == 2) {
                temp++;
            }

            res[i] = temp;
        }

        return res;
    }
}