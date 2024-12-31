import java.util.*;

class Solution {
    public long calc(long num1, long num2, char op) {
        long num = 0;
        
        switch(op) {
            case '+':
                num = num1 + num2;
                break;
            case '-':
                num = num1 - num2;
                break;
            case '*':
                num = num1 * num2;
                break;
        }
        
        return num;
    }
    public long solution(String expression) {
        long answer = Long.MIN_VALUE;
        char[][] op = {{'+', '-', '*'}, {'+', '*', '-'}, {'*', '+', '-'},
                        {'*', '-', '+'}, {'-', '*', '+'}, {'-', '+', '*'}};
        ArrayList<Long> numList = new ArrayList<>();
        ArrayList<Character> opList = new ArrayList<>();
        String num = "";
        
        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if((c - '0') >= 0 && (c - '0') <= 9) {
                num += c;
            } else {
                numList.add(Long.parseLong(num));
                opList.add(c);
                num = "";
            }
        }
        
        numList.add(Long.parseLong(num));
        
        for(int i = 0; i < op.length; i++) {
            ArrayList<Long> subNum = new ArrayList<>(numList);
            ArrayList<Character> subOp = new ArrayList<>(opList);
            for(int j = 0; j < op[i].length; j++) {
                for(int k = 0; k < subOp.size(); k++) {
                    if(subOp.get(k) == op[i][j]) {
                        long num1 = subNum.remove(k);
                        long num2 = subNum.remove(k);
                        char oper = subOp.remove(k);
                        subNum.add(k, calc(num1, num2, oper));
                        k--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(subNum.get(0)));
        }
        
        return answer;
    }
}