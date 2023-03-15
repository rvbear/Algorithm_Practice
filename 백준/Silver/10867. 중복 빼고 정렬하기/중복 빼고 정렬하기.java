import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); // 수의 개수 N
		if (N < 10 || N > 100000) // N의 범위 1<= N <= 100,000
			System.exit(0);

		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			int num = scanner.nextInt();
			array.add(num);
			if (num < (-1000) || num > 1000) // 배열 요소 값의 범위 절댓값 <= 1000
				array.remove(i--);
		}

		HashSet<Integer> arr = new HashSet<Integer>(array); // HashSet을 이용한 중복 제거
		array = new ArrayList<Integer>(arr);

		Collections.sort(array); // 배열 오름차순 정렬

		for (int i = 0; i < array.size(); i++)
			System.out.print(array.get(i) + " ");

		scanner.close();
	}
}