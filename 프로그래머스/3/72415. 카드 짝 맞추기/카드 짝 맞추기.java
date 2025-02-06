import java.util.*;

class Solution {
    int[][] record = new int[7][4];
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[] sequence;
    int answer = Integer.MAX_VALUE;
    int MAX = 16;
    int size;
    boolean[] visited = new boolean[7];
    boolean[] memo = new boolean[7];

    boolean validation(int x, int y) {
        return x >= 0 && y >= 0 && x < size && y < size;
    }

    int move(int[][] board, int startX, int startY, int endX, int endY, int curX, int curY) {
        int sum = 0;
        int[][] map = new int[size][size];

        for (int i = 0; i < size; i++) {
            Arrays.fill(map[i], MAX);
        }

        map[curX][curY] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {curX, curY});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextX = x + dir[i][0];
                int nextY = y + dir[i][1];

                if (!validation(nextX, nextY)) {
                    continue;
                }

                if (map[nextX][nextY] > map[x][y] + 1) {
                    map[nextX][nextY] = map[x][y] + 1;
                    q.add(new int[] {nextX, nextY});
                }

                if (board[nextX][nextY] != 0) {
                    continue;
                }

                boolean flag = false;
                while (true) {
                    nextX += dir[i][0];
                    nextY += dir[i][1];

                    if (!validation(nextX, nextY)) {
                        break;
                    }

                    if (board[nextX][nextY] != 0) {
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    nextX -= dir[i][0];
                    nextY -= dir[i][1];
                }

                if (map[nextX][nextY] > map[x][y] + 1) {
                    map[nextX][nextY] = map[x][y] + 1;
                    q.add(new int[] {nextX, nextY});
                }
            }
        }

        sum += map[startX][startY];

        for (int i = 0; i < size; i++) {
            Arrays.fill(map[i], MAX);
        }

        map[startX][startY] = 0;
        q.add(new int[] {startX, startY});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextX = x + dir[i][0];
                int nextY = y + dir[i][1];

                if (!validation(nextX, nextY)) {
                    continue;
                }

                if (map[nextX][nextY] > map[x][y] + 1) {
                    map[nextX][nextY] = map[x][y] + 1;
                    q.add(new int[] {nextX, nextY});
                }

                if (board[nextX][nextY] != 0) {
                    continue;
                }

                boolean flag = false;
                while (true) {
                    nextX += dir[i][0];
                    nextY += dir[i][1];

                    if (!validation(nextX, nextY)) {
                        break;
                    }

                    if (board[nextX][nextY] != 0) {
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    nextX -= dir[i][0];
                    nextY -= dir[i][1];
                }

                if (map[nextX][nextY] > map[x][y] + 1) {
                    map[nextX][nextY] = map[x][y] + 1;
                    q.add(new int[] {nextX, nextY});
                }
            }
        }

        board[startX][startY] = board[endX][endY] = 0;

        sum += map[endX][endY];
        sum += 2;
        
        return sum;
    }

    void backTracking(int[][] board, int x, int y, int count, int depth) {
        if (depth == sequence.length) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 1; i <= 6; i++) {
            if (!memo[i] || visited[i]) {
                continue;
            }

            visited[i] = true;
            sequence[depth] = i;

            int one = move(board, record[i][0], record[i][1], record[i][2], record[i][3], x, y);
            backTracking(board, record[i][2], record[i][3], count + one, depth + 1);
            board[record[i][0]][record[i][1]] = board[record[i][2]][record[i][3]] = i;

            int two = move(board, record[i][2], record[i][3], record[i][0], record[i][1], x, y);
            backTracking(board, record[i][0], record[i][1], count + two, depth + 1);
            board[record[i][2]][record[i][3]] = board[record[i][0]][record[i][1]] = i;

            visited[i] = false;
        }
    }

    public int solution(int[][] board, int r, int c) {
        size = board.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int num = board[i][j];

                if (num == 0) {
                    continue;
                }

                if (!memo[num]) {
                    record[num][0] = i;
                    record[num][1] = j;
                    memo[num] = true;
                } else {
                    record[num][2] = i;
                    record[num][3] = j;
                }
            }
        }
        
        int count = 0;
        for (int i = 1; i <= 6; i++) {
            if (memo[i]) {
                count++;
            }
        }

        sequence = new int[count];

        backTracking(board, r, c, 0, 0);

        return answer;
    }
}