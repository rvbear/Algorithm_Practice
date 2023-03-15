import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int num = scan.nextInt(); // 학생 수 입력
		ArrayList<Integer> student = new ArrayList<Integer>(); // 각자 뽑은 번호를 저장할 배열 생성

		for (int i = 0; i < num; i++) {
			int n = scan.nextInt();
			if (n == 0)		// 0일 경우 그 자리 그대로
				student.add(i + 1);
			else		// 뽑은 숫자만큼 앞으로
				student.add(student.size() - n, i + 1);
		}

		for (int i = 0; i < student.size(); i++)
			System.out.print(student.get(i) + " ");

		scan.close();
	}
}