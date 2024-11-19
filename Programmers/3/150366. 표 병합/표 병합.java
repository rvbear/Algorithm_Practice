import java.util.*;

class Solution {
    public int[] parent = new int[2501];
    public String[] value = new String[2501];
    
    public int find(int a) {
        if(parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
    
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
        }
    }
    
    public int convertNum(int x, int y) {
        int result = 50 * (x - 1);
        return result + y;
    }
    
    public String[] solution(String[] commands) {
        for(int i = 1; i < 2501; i++) {
            parent[i] = i;
            value[i] = "EMPTY";
        }
        
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < commands.length; i++) {
            StringTokenizer stk = new StringTokenizer(commands[i]);
            String command = stk.nextToken();
            
            if("UPDATE".equals(command)) {
                if(stk.countTokens() == 2) {
                    String before = stk.nextToken();
                    String after = stk.nextToken();
                    
                    for(int j = 1; j < 2501; j++) {
                        if(before.equals(value[j])) {
                            value[j] = after;
                        }
                    }
                } else {
                    int r = Integer.parseInt(stk.nextToken());
                    int c = Integer.parseInt(stk.nextToken());
                    
                    String temp = stk.nextToken();
                    int index = convertNum(r, c);
                    
                    value[find(index)] = temp;
                }
            } else if("MERGE".equals(command)) {
                int r1 = Integer.parseInt(stk.nextToken());
                int c1 = Integer.parseInt(stk.nextToken());
                int r2 = Integer.parseInt(stk.nextToken());
                int c2 = Integer.parseInt(stk.nextToken());
                
                int index1 = convertNum(r1, c1);
                int index2 = convertNum(r2, c2);
                int root1 = find(index1);
                int root2 = find(index2);

                if(root1 != root2) {
                    String rootValue = value[root1].equals("EMPTY") ? value[root2] : value[root1];
                    value[root1] = "EMPTY";
                    value[root2] = "EMPTY";
                    union(root1, root2);
                    value[root1] = rootValue;
                }
            } else if("UNMERGE".equals(command)) {
                int r = Integer.parseInt(stk.nextToken());
                int c = Integer.parseInt(stk.nextToken());
                
                int index = convertNum(r, c);
                int root = find(index);

                String rootValue = value[root];
                value[root] = "EMPTY";
                value[index] = rootValue;
                
                List<Integer> deleteList = new ArrayList<>();
                for(int j = 1; j < 2501; j++) {
                    if(find(j) == root) {
                        deleteList.add(j);
                    }
                }
                
                for(int t : deleteList) {
                    parent[t] = t;
                }
            } else if("PRINT".equals(command)) {
                int r = Integer.parseInt(stk.nextToken());
                int c = Integer.parseInt(stk.nextToken());
                int index = convertNum(r, c);
                int root = find(index);
                
                answer.add(value[root]);
            }
        }
        
        return answer.toArray(new String[0]);
    }
}