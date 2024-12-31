import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, String> map = new HashMap<String, String>();

		for (int i = 0; i < N; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			String s1 = s.nextToken();
			String s2 = s.nextToken();
			map.put(s1, s2);
		}
		for (int i = 0; i < M; i++) {
			String p = br.readLine();
			if (map.containsKey(p))
				System.out.println(map.get(p));
		}
	}
}