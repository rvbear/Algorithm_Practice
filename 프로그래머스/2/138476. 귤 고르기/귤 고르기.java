import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] arr = new int[10000001];
        
        for(int i = 0; i < tangerine.length; i++) {
            arr[tangerine[i]]++;
        }
        
        arr = Arrays.stream(arr).filter(i -> i != 0).toArray();
        Arrays.sort(arr);
        
        for(int i = arr.length-1; i >= 0; i--) {
            k -= arr[i];
            answer++;
            if(k <= 0) {
                break;
            }
        }
        
        return answer;
    }
}