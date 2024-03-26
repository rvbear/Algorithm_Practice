import java.util.*;

class Solution {
    static String[][] r;
    static Set<String> set;
    public void dfs(int index, int depth, int max, boolean[] selected) {
        if(depth == max) {
            String cols = "";
            for(int i = 0; i < selected.length; i++) {
                cols += selected[i] ? i : "";
            }
            
            if(possible(cols, selected)) {
                set.add(cols);
            }
            
            return;
        }
        
        if(index >= selected.length) {
            return;
        }
        
        selected[index] = true;
        dfs(index + 1, depth + 1, max, selected);
        selected[index] = false;
        dfs(index + 1, depth, max, selected);
    }
    public boolean possible(String cols, boolean[] selected) {
        for(String s : set) {
            boolean flag = true;
            
            for(int i = 0; i < s.length(); i++) {
                if(!cols.contains(s.charAt(i) + "")) {
                    flag = false;
                }
            }
            
            if(flag) {
                return false;
            }
        }
        
        Set<String> value = new HashSet<>();
        int[] col = new int[cols.length()];
        int index = 0;
        
        for(int i = 0; i < selected.length; i++) {
            if(selected[i]) {
                col[index++] = i;
            }
        }
        
        String v = "";
        for(int i = 0; i < r.length; i++) {
            v = "";
            for(int j = 0; j < col.length; j++) {
                v += r[i][col[j]];
            }
            if(value.contains(v)) {
                return false;
            } else {
                value.add(v);
            }
        }
        
        return true;
    }
    public int solution(String[][] relation) {
        r = relation;
        set = new HashSet<>();
        
        for(int i = 1; i <= relation[0].length; i++) {
            boolean[] selected = new boolean[relation[0].length];
            dfs(0, 0, i, selected);
        }
        
        return set.size();
    }
}