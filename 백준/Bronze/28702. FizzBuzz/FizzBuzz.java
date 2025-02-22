import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        boolean flag = false;

        for (int i = 0; i < 3; i++) {
            String input = br.readLine();

            if (input.charAt(0) != 'F' && input.charAt(0) != 'B') {
                flag = true;
                num = Integer.parseInt(input);
            }

            num += flag ? 1 : 0;
        }

        System.out.println(num % 5 == 0 && num % 3 == 0 ? "FizzBuzz" : (num % 5 == 0 ? "Buzz" : (num % 3 == 0 ? "Fizz" : num)));
    }
}
