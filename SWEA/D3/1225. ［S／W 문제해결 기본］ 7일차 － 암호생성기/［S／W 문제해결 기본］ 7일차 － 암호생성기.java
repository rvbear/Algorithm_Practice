import java.util.*;

class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++) {
			int caseNum = sc.nextInt();
			int minus = 1;
			List<Integer> arr = new ArrayList<>();
			
			for (int j = 0; j < 8; j++) {
				arr.add(sc.nextInt());
			}
			
			while (true) {
				int val = arr.remove(0) - minus++;
				
				if (val <= 0) {
					arr.add(0);
					break;
				}
				
				arr.add(val);
				
				if (minus > 5) {
					minus = 1;
				}
			}
			
			String answer = "";
			
			for (int x : arr) {
				answer += x + " ";
			}
			
			System.out.println("#" + caseNum + " " + answer);
		}
	}
}
