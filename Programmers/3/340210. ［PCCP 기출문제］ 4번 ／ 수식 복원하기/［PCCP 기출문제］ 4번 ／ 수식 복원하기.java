import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        List<String> complete = new ArrayList<>();
        List<String> problem = new ArrayList<>();

        for (String expression : expressions) {
            if (!expression.contains("X")) {
                complete.add(expression);
            } else {
                problem.add(expression);
            }
        }

        String[] result = new String[problem.size()];
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 0);
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);
        map.put(7, 0);
        map.put(8, 0);
        map.put(9, 0);

        int maxDigitInComplete = 0;

        for(String s : complete) {
            String[] temp = s.split(" ");
            int maxDigit = Math.max(getMaxDigit(temp[0]), getMaxDigit(temp[2]));
            maxDigit = Math.max(maxDigit, getMaxDigit(temp[4]));
            maxDigitInComplete = Math.max(maxDigit, maxDigitInComplete);
        }
        
        int minBaseInComplete = maxDigitInComplete + 1;

        for(String s : complete) {
            String[] temp = s.split(" ");
            String op = temp[1];

            for(int i = minBaseInComplete; i <= 9; i++) {
                check(temp, i, op, map);
            }
        }

        int maxDigitInProblem = 0;

        for(String s : problem) {
            String[] temp = s.split(" ");
            int maxDigit = Math.max(getMaxDigit(temp[0]), getMaxDigit(temp[2]));
            maxDigitInProblem = Math.max(maxDigit, maxDigitInProblem);
        }
        
        int minBaseInProblem = maxDigitInProblem + 1;


        for (int i = 0; i < problem.size(); i++) {
            String[] temp = problem.get(i).split(" ");
            String op = temp[1];

            Set<String> resultSet = new HashSet<>();

            for(int j = minBaseInProblem; j <= 9; j++) {
                int value = map.get(j);
                if(value == complete.size()) {
                    checkSet(temp, j, op, resultSet);
                }
            }


            if(resultSet.size() != 1) {
                result[i] = temp[0] + " " + temp[1] + " " + temp[2] + " " + temp[3] + " " + "?";
            } else {
                Iterator<String> it = resultSet.iterator();
                if(it.hasNext()) {
                    String value = it.next();
                    result[i] = temp[0] + " " + temp[1] + " " + temp[2] + " " + temp[3] + " " + value;
                }
            }
        }
        
        return result;
    }

    private void checkSet(String[] temp, int base, String op, Set<String> resultSet) {
        if(!isValidNumber(temp[0], base) || !isValidNumber(temp[2], base)) {
            return;
        }
        int num1 = Integer.parseInt(temp[0], base);
        int num2 = Integer.parseInt(temp[2], base);


        int res = op.equals("+") ? num1 + num2 : num1 - num2;

        String ans = Integer.toString(res, base);
        resultSet.add(ans);
    }

    private int getMaxDigit(String number) {
        int maxDigit = 0;
        for(char c : number.toCharArray()) {
            if(Character.isDigit(c)) {
                maxDigit = Math.max(maxDigit, Character.getNumericValue(c));
            }
        }
        return maxDigit;
    }

    private boolean isValidNumber(String number, int base) {
        for(char c : number.toCharArray()) {
            int digit = Character.getNumericValue(c);
            if(digit < 0 || digit >= base) {
                return false;
            }
        }
        return true;
    }

    private void check(String[] parts, int base, String op, Map<Integer, Integer> expressionMap) {
        if(!isValidNumber(parts[0], base) || !isValidNumber(parts[2], base) || !isValidNumber(parts[4], base)) {
            return;
        }
        int num1 = Integer.parseInt(parts[0], base);
        int num2 = Integer.parseInt(parts[2], base);
        int res = op.equals("+") ? num1 + num2 : num1 - num2;

        String ans = Integer.toString(res, base);

        if(ans.equals(parts[4])) {
            expressionMap.merge(base, 1, Integer::sum);
        }
    }
}