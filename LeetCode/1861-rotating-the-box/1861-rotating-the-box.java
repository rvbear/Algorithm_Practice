class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;
        char[][] result = new char[m][n];
        for(char[] c : result) {
            Arrays.fill(c, '.');
        }

        for(int i = 0; i < n; i++) {
            int index = m - 1;
            for(int j = m-1; j >= 0; j--) {
                if(box[i][j] == '#') {
                    result[index][n-i-1] = '#';
                    index--;
                } else if(box[i][j] == '*') {
                    result[j][n-i-1] = '*';
                    index = j-1;
                }
            }
        }

        return result;
    }
}