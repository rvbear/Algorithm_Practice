import java.io.*;
import java.util.*;

class Point implements Comparable<Point>{
    int x, y;

    public Point(int _x, int _y) {
        x = _x; y = _y;
    }

    @Override
    public int compareTo(Point p) {
        if (x == p.x) {
            return y > p.y ? 1 : -1;
        }
        return x > p.x ? 1 : -1;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
        }

        Arrays.sort(points);

        for(Point p : points) {
            bw.write(String.valueOf(p.x) + " " + String.valueOf(p.y) + "\n");
        }
        br.close(); bw.close();
    }
}