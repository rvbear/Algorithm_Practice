import java.util.*;

class Solution {
    int n, max = Integer.MIN_VALUE;
    int[] answer;
    int[][] dices;
    List<Integer> arrA;
    List<Integer> arrB;
    List<Integer> choice;
    
    public void makeArr(int depth, int[][] dice, int sum, List<Integer> arr) {
        if(depth == n / 2) {
            arr.add(sum);
            return;
        }
        for(int i = 0; i < 6; i++) {
            int newSum = sum + dice[depth][i];
            makeArr(depth + 1, dice, newSum, arr);
        }
    }

    public void makeArrAB() {
        arrA = new ArrayList<>();
        arrB = new ArrayList<>();

        int[][] diceA = new int[n / 2][6];
        int[][] diceB = new int[n / 2][6];
        int a = 0, b = 0;
        for(int i = 0; i < n; i++) {
            if(choice.contains(i)) {
                diceA[a] = dices[i];
                a++;
            } else {
                diceB[b] = dices[i];
                b++;
            }
        }

        makeArr(0, diceA, 0, arrA);
        makeArr(0, diceB, 0, arrB);
    }

    public int calculateWinningPercent() {
        int count = 0;

        makeArrAB();

        Collections.sort(arrB);
        for(int i = 0; i < arrA.size(); i++) {
            int number = arrA.get(i);

            int left = 0, right = arrB.size() - 1;

            int index = Integer.MIN_VALUE;
            while(left <= right) {
                int middle = (left + right) / 2;

                if(arrB.get(middle) < number) {
                    left = middle + 1;
                    index = Math.max(index, middle);
                } else {
                    right = middle - 1;
                }
            }
            if(index != Integer.MIN_VALUE) {
                count += index + 1;
            }
        }
        return count;
    }

    public void dfs(int depth, int s) {
        if (depth == n / 2) {
            int winning = calculateWinningPercent();
            if (max < winning) {
                max = winning;
                for (int i = 0; i < choice.size(); i++) {
                    answer[i] = choice.get(i) + 1;
                }
            }
            return;
        }
        for (int i = s; i < n; i++) {
            choice.add(i);
            dfs(depth + 1, i + 1);
            choice.remove(choice.size() - 1);
        }
    }
    
    public int[] solution(int[][] dice) {
        n = dice.length;
        answer = new int[n / 2];
        dices = dice;
        arrA = new ArrayList<>();
        arrB = new ArrayList<>();
        choice = new ArrayList<>();
        
        dfs(0, 0);
        
        return answer;
    }
}