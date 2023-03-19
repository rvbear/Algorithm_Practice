import java.io.*;

class resistance {          // 저항 클래스
    private String color;       // 색
    private int value;          // 값
    private int mul;            // 곱

    public resistance(String color, int value, int mul) {   // 생성자
        this.color = color; this.value = value; this.mul = mul;
    }

    public String getColor() {      // color 반환
        return color;
    }

    public int getValue() {         // value 값을 반환
        return value;
    }

    public int getMul() {           // mul 값을 반환
        return mul;
    }
}

public class Main {
    public static resistance[] init() {     // 저항 초깃값 설정
        resistance[] array = {new resistance("black", 0, 1),
                            new resistance("brown", 1, 10),
                            new resistance("red", 2, 100),
                            new resistance("orange", 3, 1000),
                            new resistance("yellow", 4, 10000),
                            new resistance("green", 5, 100000),
                            new resistance("blue", 6, 1000000),
                            new resistance("violet", 7, 10000000),
                            new resistance("grey", 8, 100000000),
                            new resistance("white", 9, 1000000000)};
        return array;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        resistance[] array = init();

        int value1 = 0, value2 = 0, mul = 0;    // 값1, 값2, 곱의 변수 생성

        for(int i = 0; i < 3; i++) {            // 3번의 반복
            String color = br.readLine();       // 저항의 색 입력
            for(int j = 0; j < array.length; j++)
                if(color.equals(array[j].getColor()))       // 클래스 배열을 사용하여 color를 불러와 비교
                    switch (i) {
                        case 0:         // i = 0 이고 color가 같다면 value1에 value값을 저장
                            value1 = array[j].getValue();
                            break;
                        case 1:         // i = 1 이고 color가 같다면 value2에 value값을 저장
                            value2 = array[j].getValue();
                            break;
                        case 2:         // i = 2 이고 color가 같다면 mul에 mul값을 저장
                            mul = array[j].getMul();
                            break;
                    }
        }

        br.close();     // 입력 버퍼 스트림 닫아줌

        // (첫번째 색의 값 * 10 + 두번째 색의 값) * 세번째 색의 곱
        System.out.println(((long) value1 * 10 + value2) * mul);
    }
}