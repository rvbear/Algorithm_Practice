import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        List<String> spoilerWords = new ArrayList<>();
        Set<String> noSpoilerWords = new HashSet<>();
        int curIndex = 0;
        
        for (String word : message.split(" ")) {
            int start = message.indexOf(word, curIndex);
            int end = start + word.length() - 1;
            curIndex = end + 1;
            boolean isSpoiler = false;
            
            for (int[] range : spoiler_ranges) {
                if (start <= range[1] && range[0] <= end) {
                    spoilerWords.add(word);
                    isSpoiler = true;
                    break;
                }
            }
            
            if (!isSpoiler) {
                noSpoilerWords.add(word);
            }
        }
        
        Set<String> importantWords = new HashSet<>();
        
        for (String spoilerWord : spoilerWords) {
            if (!importantWords.contains(spoilerWord) && !noSpoilerWords.contains(spoilerWord)) {
                importantWords.add(spoilerWord);
            }
        }
        
        return importantWords.size();
    }
}
