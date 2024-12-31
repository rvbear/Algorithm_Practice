import java.util.*;

class Solution {
    public int gcd(int a, int b) {
        if(b == 0) 
            return a;
        else 
            return gcd(b, a % b);
    }
    public boolean check(int[] array, int div) {
        for(int n : array)
            if(n % div == 0) 
                return true;
        
        return false;
    }
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(arrayA[i], gcdA);
            gcdB = gcd(arrayB[i], gcdB);
        }
        
        if(!check(arrayA, gcdB)) 
            answer = Math.max(answer, gcdB);
        
        if(!check(arrayB, gcdA)) 
            answer = Math.max(answer, gcdA);
        
        return answer;
    }
}