import java.util.stream.*;

class Solution {
    public int solution(int a, int d, boolean[] included) {
        return IntStream.range(0, included.length)
            .map(p -> included[p] == true ? a + p * d : 0)
            .sum();
    }
}