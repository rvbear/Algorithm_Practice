import java.util.*;

public class Main {
	public static void main(String[] args) {
		HashMap<String, String> memo = new HashMap<String, String>();
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt(); // 저장된 사이트 주소의 수
		int m = scan.nextInt(); // 비밀번호를 찾으려는 사이트 주소의 수

		for (int i = 0; i < n; i++) { // 저장할 사이트와 비밀번호를 입력
			String web = scan.next();
			String pwd = scan.next();
			memo.put(web, pwd);
		}

		String[] web = new String[m]; // 사이트 주소를 저장하는 배열

		for (int i = 0; i < m; i++) { // 지정된 수만큼 비밀번호를 찾으려는 사이트 주소를 입력
			web[i] = scan.next();
		}

		for (int i = 0; i < m; i++) { // 배열의 요소들을 키값으로 비밀번호를 출력
			String values = memo.get(web[i]);
			System.out.println(values);
		}

		scan.close();
	}
}