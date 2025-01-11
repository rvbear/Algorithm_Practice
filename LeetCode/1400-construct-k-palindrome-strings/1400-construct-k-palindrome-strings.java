class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k) {
            return false;
        }

        char[] c = s.toCharArray();
        Arrays.sort(c);
        int odd = 0;

        for(int i = 0; i < c.length;) {
            char cur = c[i];
            int cnt = 0;
            
            while(i < c.length && c[i] == cur) {
                cnt++;
                i++;
            }

            if(cnt % 2 != 0) {
                odd++;
            }
        }

        return odd <= k;
    }
}