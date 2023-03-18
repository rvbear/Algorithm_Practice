import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 입력 스트림을 통해 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));     // 버퍼 출력 스트림을 통해 출력

        int N = Integer.parseInt(br.readLine());        // 맥주병 개수를 입력

        for(int i = N; i >= 0; i--) {       // (N+1)번 만큼 진행
            if(i == 0) {     // 맥주병이 없을 경우
                if(N == 1)     // 입력이 1일 경우
                    bw.write("No more bottles of beer on the wall, no more bottles of beer.\n" +
                            "Go to the store and buy some more, 1 bottle of beer on the wall.\n");
                else    // 그 외의 경우
                    bw.write("No more bottles of beer on the wall, no more bottles of beer.\n" +
                            "Go to the store and buy some more, " + N + " bottles of beer on the wall.\n");
            }
            else if(i == 1)     // 맥주병이 한 병 남았을 경우
                bw.write("1 bottle of beer on the wall, 1 bottle of beer.\n" +
                        "Take one down and pass it around, no more bottles of beer on the wall.\n\n");
            else if(i == 2)     // 맥주병이 두 병 남았을 경우
                bw.write("2 bottles of beer on the wall, 2 bottles of beer.\n" +
                        "Take one down and pass it around, 1 bottle of beer on the wall.\n\n");
            else        // 맥주병이 여러 병 남았을 경우
                bw.write(i + " bottles of beer on the wall, " + i + " bottles of beer.\n" +
                        "Take one down and pass it around, " + (i - 1) + " bottles of beer on the wall.\n\n");
        }

        br.close();     // 버퍼 입력 스트림 닫아줌
        bw.close();     // 버퍼에 저장된 값을 출력 (flush() 내장되어있음)
    }
}