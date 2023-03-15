import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt(); // 우유 가게의 수
		int[] store = new int[N]; // 우유 가게의 정보를 저장하는 배열
		for (int i = 0; i < store.length; i++) // 우유 가게의 정보 저장
			store[i] = scan.nextInt();

		int count = 0; // 최대로 마실 수 있는 우유의 개수
		int a = 0;
		for (int i = 0; i < store.length; i++) {
			if (a == 0 && store[i] == 0) {
				a = 1;
				count++;
			}
			if (a == 1 && store[i] == 1) {
				a = 2;
				count++;
			}
			if (a == 2 && store[i] == 2) {
				a = 0;
				count++;
			}
		}

		System.out.println(count);
		scan.close();
	}
}