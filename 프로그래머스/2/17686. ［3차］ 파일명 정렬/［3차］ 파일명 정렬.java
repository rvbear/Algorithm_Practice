import java.util.*;

class Solution {
    public String[] detach(String file) {
        String head = "", number = "", tail = "";
        int index = 0;
        
        for(; index < file.length(); index++) {
            char c = file.charAt(index);
            if(c >= '0' && c <= '9') {
                break;
            }
            head += file.charAt(index);
        }
        
        for(; index < file.length(); index++) {
            char c = file.charAt(index);
            if(c < '0' || c > '9') {
                break;
            }
            number += file.charAt(index);
        }
        
        tail = file.substring(index);
        
        return new String[] {head.toLowerCase(), number, tail};
    }
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
           @Override
            public int compare(String s1, String s2) {
                String[] file1 = detach(s1);
                String[] file2 = detach(s2);
                
                int headValue = file1[0].compareTo(file2[0]);
                
                if(headValue == 0) {
                    int number1 = Integer.parseInt(file1[1]);
                    int number2 = Integer.parseInt(file2[1]);
                    
                    return number1 - number2;
                } else {
                    return headValue;
                }
            }
        });
        
        return files;
    }
}