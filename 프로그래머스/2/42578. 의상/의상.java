import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
				// HashMap을 사용
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
						// 분류를 키값으로 가지고 있다면 value + 1, 아니라면 0 + 1을 해줌
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
				// 모든 key값을 조회
        for(String key : map.keySet()) {
						// 결과에 value + 1을 곱해줌
            answer *= (map.get(key) + 1);
        }
        
				// 최종 결과값 - 1을 해줌
        return answer - 1;
    }
}
