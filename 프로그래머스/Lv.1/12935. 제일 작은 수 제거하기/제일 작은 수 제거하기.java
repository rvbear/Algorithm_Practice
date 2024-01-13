import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) {
            return new int[] {-1};
        }

        int[] result = Arrays.stream(arr)
                        .filter(value -> value != Arrays.stream(arr).min().getAsInt())
                        .toArray();
        
        return result;
    }
}