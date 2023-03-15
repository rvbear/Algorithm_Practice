import java.util.*;

public class Main {
	public static void show(int count) {
		switch (count) {
		case 0:
			System.out.println("E");
			break;
		case 1:
			System.out.println("A");
			break;
		case 2:
			System.out.println("B");
			break;
		case 3:
			System.out.println("C");
			break;
		case 4:
			System.out.println("D");
			break;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;

		for (int i = 0; i < 4; i++) {
			int a = scan.nextInt();
			if (a == 0)
				count1++;
		}

		for (int i = 0; i < 4; i++) {
			int a = scan.nextInt();
			if (a == 0)
				count2++;
		}

		for (int i = 0; i < 4; i++) {
			int a = scan.nextInt();
			if (a == 0)
				count3++;
		}

		show(count1);
		show(count2);
		show(count3);

		scan.close();
	}
}