import java.util.*;

class Solution {
    public int numTilePossibilities(String tiles) {
        int[] cnt = new int[26];
        int[] fac = new int[tiles.length() + 1];
        fac[0] = 1;

        for (int i = 1; i < fac.length; i++) {
            fac[i] = i * fac[i - 1];
        }

        for (int i = 0; i < tiles.length(); i++) {
            cnt[tiles.charAt(i) - 'A']++;
        }

        int[] lengthCnt = new int[tiles.length() + 1];
        lengthCnt[0] = 1;

        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] != 0) {
                int[] temp = new int[tiles.length() + 1];

                for (int j = 0; j < lengthCnt.length && lengthCnt[j] > 0; j++) {
                    for (int k = 1; k <= cnt[i]; k++) {
                        int totalLength = j + k;
                        temp[totalLength] += lengthCnt[j] * fac[totalLength] / (fac[k] * fac[j]);
                    }
                }

                for (int j = 0; j < temp.length; j++) {
                    lengthCnt[j] += temp[j];
                }
            }
        }

        int ans = 0;

        for (int i = 1; i < lengthCnt.length; i++) {
            ans += lengthCnt[i];
        }

        return ans;
    }
}
