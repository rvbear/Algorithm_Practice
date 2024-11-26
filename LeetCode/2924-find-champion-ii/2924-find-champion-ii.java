class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean[] isUndefeated = new boolean[n];
        Arrays.fill(isUndefeated, true);

        for(int[] edge : edges) {
            int winner = edge[0];
            int loser = edge[1];
            isUndefeated[loser] = false;
        }

        int champion = -1;
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(isUndefeated[i]) {
                champion = i;
                count++;
            }
        }

        return count == 1 ? champion : -1;
    }
}