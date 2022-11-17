import java.util.*;

public class Main {
	public static void print(int n) {
		while (n != 0) {
			System.out.print("*");
			n--;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();

		while (N != 0) {
			print(N);
			System.out.println();
			N--;
		}
	}
}