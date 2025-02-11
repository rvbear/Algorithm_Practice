import java.util.*;

class Solution {
    public String removeOccurrences(String s, String part) {
        char[] input = s.toCharArray();
        char[] target = part.toCharArray();
        char[] stack = new char[input.length];
        int stackSize = 0, targetLength = target.length;
        char targetEndChar = target[targetLength - 1];

        for (char currentChar : input) {
            stack[stackSize++] = currentChar;

            if (currentChar == targetEndChar && stackSize >= targetLength) {
                int i = stackSize - 1, j = targetLength - 1;
                
                while (j >= 0 && stack[i] == target[j]) {
                    i--;
                    j--;
                }

                if (j < 0) {
                    stackSize = i + 1;
                }
            }
        }

        return new String(stack, 0, stackSize);
    }
}