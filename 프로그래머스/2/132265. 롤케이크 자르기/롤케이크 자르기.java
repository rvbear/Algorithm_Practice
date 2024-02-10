import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
		// 자른 것을 기준으로 오른쪽을 뜻하는 Map
        Map<Integer, Integer> right = new HashMap<>();
        // 자른 것을 기준으로 왼쪽을 뜻하는 Set
		Set<Integer> left = new HashSet<>();
        
		// 오른쪽에 모든 값을 다 저장
        for(int t : topping) {
            right.put(t, right.getOrDefault(t, 0) + 1);
        }
        
		// 맨 처음부터 하나씩 잘라가면서 비교
        for(int t : topping) {
            right.put(t, right.get(t) - 1);
            left.add(t);
            
			// 해당 토핑이 존재하지 않을 경우 삭제
            if(right.get(t) == 0) {
                right.remove(t);
            }
            
			// 왼쪽과 오른쪽의 토핑 수가 같으면 answer 증가
            if(right.size() == left.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}
