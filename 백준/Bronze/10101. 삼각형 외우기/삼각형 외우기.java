import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;                                            // 삼각형 세 변의 길이의 합 저장
        int[] triangle = new int[3];                            // 삼각형 각 변의 길이 저장
        for(int i = 0; i < 3; i++) {
            triangle[i] = Integer.parseInt(br.readLine());
            sum += triangle[i];
        }

        // 삼각형이 아니라면
        if(sum != 180) System.out.println("Error");
        // 정삼각형이라면
        else if(triangle[0] == triangle[1] && triangle[1] == triangle[2])
            System.out.println("Equilateral");
        // 이등변삼각형이라면 
        else if(triangle[0] == triangle[1] || triangle[0] == triangle[2] || triangle[1] == triangle[2])
            System.out.println("Isosceles");
        // 삼각형이라면
        else System.out.println("Scalene");

        br.close();
    }
}