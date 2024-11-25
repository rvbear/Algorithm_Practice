import java.util.*;
import java.io.*;

class Solution {
    private String swap(String state, int i, int j) {
        StringBuilder s = new StringBuilder(state);
        s.setCharAt(i, state.charAt(j));
        s.setCharAt(j, state.charAt(i));

        return s.toString();
    }
    public int slidingPuzzle(int[][] board) {
        int[][] dir = new int[][] {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        String target = "123450";
        StringBuilder stb = new StringBuilder();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                stb.append(board[i][j]);
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(stb.toString());
        int l, moves = 0;

        while(!q.isEmpty()) {
            l = q.size();
            for(int i = 0; i < l; i++) {
                String cur = q.poll();
                if(cur.equals(target)) {
                    return moves;
                }

                int zeroIdx = cur.indexOf('0');
                for(int newIdx : dir[zeroIdx]) {
                    String next = swap(cur, zeroIdx, newIdx);
                    if(visited.contains(next)) {
                        continue;
                    }
                    q.add(next);
                    visited.add(next);
                }
            }
            moves++;
        }

        return -1;
    }
}