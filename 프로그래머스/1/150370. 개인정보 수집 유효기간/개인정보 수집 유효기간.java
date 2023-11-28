import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int year = Integer.parseInt(today.substring(0, 4));
        int month = Integer.parseInt(today.substring(5, 7));
        int day = Integer.parseInt(today.substring(8));
        int count = year*12*28 + month*28 + day;
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++) {
            for(String term : terms) {
                if(term.charAt(0) == privacies[i].charAt(11)) {
                    String[] arr = term.split(" ");
                    int period = Integer.parseInt(arr[1]) * 28;
                    year = Integer.parseInt(privacies[i].substring(0, 4));
                    month = Integer.parseInt(privacies[i].substring(5, 7));
                    day = Integer.parseInt(privacies[i].substring(8, 10));
                    int temp = year*12*28 + month*28 + day;
                    if(temp + period <= count) {
                        list.add(i);
                    }
                }
            }
        }
        
        int[] answer = new int[list.size()];
        int index = 0;
        for(int i : list) {
            answer[index++] = i+1;
        }
        return answer;
    }
}