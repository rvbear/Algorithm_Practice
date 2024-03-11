import java.util.*;

class Solution {
    static class Node {
        int a, b, c;
        
        public Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 1;
        ArrayList<ArrayList<Node>> map = new ArrayList<>();
        
        for(int i = 0; i < N + 1; i++)
            map.add(new ArrayList<>());
        
        for(int i = 0; i < road.length; i++) {
            map.get(road[i][0]).add(new Node(road[i][0], road[i][1], road[i][2]));
            map.get(road[i][1]).add(new Node(road[i][1], road[i][0], road[i][2]));
        }
        
        Queue<Node> q = new LinkedList<>();
        int[] time = new int[N+1];
        
        for(int i = 2; i < N+1; i++)
            time[i] = Integer.MAX_VALUE;
            
        q.addAll(map.get(1));
        
        while(!q.isEmpty()) {
            Node n = q.poll();
            
            if(time[n.b] <= time[n.a] + n.c) continue;
            
            time[n.b] = time[n.a] + n.c;
            q.addAll(map.get(n.b));
        }

        for(int i = 2; i < time.length; i++)
            if(time[i] <= K) answer++;
        
        return answer;
    }
}