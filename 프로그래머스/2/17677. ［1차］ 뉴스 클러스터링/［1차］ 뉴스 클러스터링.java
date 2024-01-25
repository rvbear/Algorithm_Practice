import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        double answer = 0;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();
        
        for(int i = 0; i < str1.length() - 1; i++) {
            String sub = str1.substring(i, i+2);
            
            if(sub.charAt(0) >= 'a' && sub.charAt(0) <= 'z'
              && sub.charAt(1) >= 'a' && sub.charAt(1) <= 'z') {
                list1.add(sub);
            }
        }
        
        for(int i = 0; i < str2.length() - 1; i++) {
            String sub = str2.substring(i, i+2);
            
            if(sub.charAt(0) >= 'a' && sub.charAt(0) <= 'z'
              && sub.charAt(1) >= 'a' && sub.charAt(1) <= 'z') {
                list2.add(sub);
            }
        }
        
        Collections.sort(list1);
        Collections.sort(list2);
        
        for(String s : list1) {
            if(list2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }
        
        for(String s : list2) {
            union.add(s);
        }
        
        answer = union.size() == 0 ? 1 : (double)intersection.size() / (double)union.size();
        
        return (int)(answer * 65536);
    }
}