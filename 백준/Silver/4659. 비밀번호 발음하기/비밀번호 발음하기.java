import java.util.*;

public class Main {
	Scanner scan = new Scanner(System.in);
	ArrayList<String> example = new ArrayList<String>();

	public Main() {
		while (true) {
			String test = scan.nextLine();
			if (test.equals("end"))
				break;
			example.add(test);
		}

		for (int i = 0; i < example.size(); i++) {
			char[] Array = example.get(i).toCharArray();
			if (check(Array))
				System.out.println("<" + example.get(i) + "> is acceptable.");
			else
				System.out.println("<" + example.get(i) + "> is not acceptable.");
		}
	}

	public boolean check(char[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (M_check(array[i]))
				count++;
			if (i > 1 && i < array.length) {
				if (M_check(array[i - 2]) == false && M_check(array[i - 1]) == false && M_check(array[i]) == false)
					return false;
				else if (M_check(array[i - 2]) && M_check(array[i - 1]) && M_check(array[i]))
					return false;
			}
			if (i > 0 && i < array.length)
				if (array[i - 1] == array[i]) {
					if (array[i - 1] == 'e' || array[i] == 'o')
						break;
					else
						return false;
				}
		}
		if (count == 0)
			return false;
		return true;
	}

	public boolean M_check(char a) {
		switch (a) {
		case 'a':
			return true;
		case 'e':
			return true;
		case 'i':
			return true;
		case 'o':
			return true;
		case 'u':
			return true;
		default:
			return false;
		}
	}

	public static void main(String[] args) {
		new Main();
	}
}