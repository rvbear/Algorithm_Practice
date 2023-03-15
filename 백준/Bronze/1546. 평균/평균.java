import java.util.*;

public class Main {
	public Main() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(); // 과목의 수
		double[] score = new double[N];
		double sum = 0; // 합계

		for (int i = 0; i < N; i++) // 과목의 점수 입력
			score[i] = scan.nextInt();

		Arrays.sort(score); // 배열 오름차순 정렬

		for (int i = 0; i < N; i++) // 점수/최대점수*100으로 점수를 반환한 뒤 모두 더함
			sum += score[i] / score[N - 1] * 100;

		System.out.println((double) (sum / score.length));

		scan.close();
	}

	public static void main(String[] args) {
		new Main();
	}
}