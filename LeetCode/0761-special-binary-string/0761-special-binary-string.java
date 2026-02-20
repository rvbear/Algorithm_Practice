class Solution {
    public String makeLargestSpecial(String s) {
        if (s == null || s.length() == 0 || s.length() == 2) {
            return s;
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));
        int acc = 1, prev = 0;

        for (int i = 1; i <= s.length(); i++) {
            if (acc == 0) {
                if (!(prev == 0 && i == s.length())) {
                    pq.add(makeLargestSpecial(s.substring(prev, i)));
                }

                prev = i;
            }

            if (i == s.length()) {
                break;
            }

            if (s.charAt(i) == '1') {
                acc++;
            } else {
                acc--;
            }
        }

        StringBuilder sb = new StringBuilder();
        
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }

        if (sb.length() == 0) {
            sb.append('1');
            sb.append(makeLargestSpecial(s.substring(1, s.length() - 1)));
            sb.append('0');
        }

        return sb.toString();
    }
}