import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int[] arr = new int[elements.length * 2];
        
        for(int i = 0; i < elements.length; i++) {
            arr[i] = arr[i + elements.length] = elements[i];
        }
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < elements.length; i++) {
            int sum = 0;
            for(int j = i; j < i + elements.length - 1; j++) {
                sum += arr[j];
                set.add(sum);
            }
        }
        
        return set.size() + 1;
    }
}