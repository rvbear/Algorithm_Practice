import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length());
        s = s.substring(0, s.length()-2);
        s = s.replace("},{", " ");
        String[] arr = s.split(" ");
        Arrays.sort(arr, new Comparator<String>() {
           public int compare(String s1, String s2) {
               return Integer.compare(s1.length(), s2.length());
           } 
        });
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            String[] temp = arr[i].split(",");
            for(int j = 0; j < temp.length; j++) {
                int add = Integer.parseInt(temp[j]);
                if(!list.contains(add)) {
                    list.add(add);
                }
            }
        }
          
        int[] answer = new int[list.size()];
        int index = 0;
        
        for(int result : list) {
            answer[index++] = result;
        }
        
        return answer;
    }
}