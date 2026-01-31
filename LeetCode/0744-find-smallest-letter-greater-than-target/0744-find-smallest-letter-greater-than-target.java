class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans = letters[0];
        Arrays.sort(letters);
        int t = target - 'a';
        
        for (int i = 0; i < letters.length; i++) {
            if (t < letters[i] - 'a') {
                return letters[i];
            }
        }

        return ans;
    }
}