import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while((a - b) != 0) {
            a += (a % 2 == 1) ? 1 : 0;
            b += (b % 2 == 1) ? 1 : 0;
            a /= 2;
            b /= 2;
            answer++;
        }

        return answer;
    }
}