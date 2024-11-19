class Solution {
    int[] answer;
    public boolean check(int[][] arr, int x, int y, int size, int temp) {
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(arr[i][j] != temp) {
                    return false;
                }
            }
        }
        return true;
    }
    public void quad(int[][] arr, int x, int y, int size) {
        if(check(arr, x, y, size, arr[x][y])) {
            int temp = arr[x][y] == 0 ? answer[0]++ : answer[1]++;
            return;
        }
        quad(arr, x, y, size/2);
        quad(arr, x, y + size/2, size/2);
        quad(arr, x + size/2, y, size/2);
        quad(arr, x + size/2, y + size/2, size/2);
    }
    public int[] solution(int[][] arr) {
        answer = new int[2];
        quad(arr, 0, 0, arr.length);
        
        return answer;
    }
}