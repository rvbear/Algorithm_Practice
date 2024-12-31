import java.io.*;

public class Main {
    public static int GCD(int a, int b) {               // 최대공약수 구하기(유클리드 호제법)
        if(b == 0) return a;
        else return GCD(b, a%b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());            // 이미 심어져 있는 가로수의 수
        int[] trees = new int[N];                           // 가로수의 위치를 저장할 배열

        for(int i = 0; i < N; i++)
            trees[i] = Integer.parseInt(br.readLine());

        int gcd = 0;
        for(int i = 1; i < N; i++)                          // 가로수 간격의 최대공약수 구하기
            gcd = GCD(trees[i] - trees[i-1], gcd);

        // (가장 마지막 위치 - 가장 첫번째 위치)/최대공약수 - 이미 심어져 있는 가로수의 개수 + 1 = 설치해야할 최소 가로수의 개수
        System.out.println((trees[N-1] - trees[0])/gcd - trees.length + 1);
        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}