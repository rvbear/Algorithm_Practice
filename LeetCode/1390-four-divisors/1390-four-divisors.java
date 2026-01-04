class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;

        for (int n : nums) {
            if (n < 6) {
                continue;
            }

            int divisorCount = 0, divisorSum = 0;

            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    int j = n / i;

                    if (i == j) {
                        divisorCount += 1;
                        divisorSum += i;
                    } else {
                        divisorCount += 2;
                        divisorSum += (i + j);
                    }

                    if (divisorCount > 4) {
                        break;
                    }
                }
            }

            if (divisorCount == 4) {
                sum += divisorSum;
            }
        }

        return sum;
    }
}