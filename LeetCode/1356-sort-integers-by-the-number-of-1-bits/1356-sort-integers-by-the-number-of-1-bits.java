class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(temp, (a, b) -> {
            int cntA = Integer.bitCount(a);
            int cntB = Integer.bitCount(b);

            if (cntA == cntB) {
                return a - b;
            }

            return cntA - cntB;
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

        return arr;
    }
}