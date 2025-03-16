import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int gap;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int solve(int idx, int score, ArrayList<Pair> oth) {
        if (gap < score)
            return -1;
        int s = -1, e = oth.size(), mid;
        while (s + 1 < e) {
            mid = (s + e) >> 1;
            if (gap < score + oth.get(mid).score)
                e = mid;
            else
                s = mid;
        }
        for (int i = e; i < oth.size(); i++)
            if (idx != oth.get(i).idx)
                return i;
        return -2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        gap = A - B;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Pair> L = new ArrayList<>(), R = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            L.add(new Pair(i, Integer.parseInt(st.nextToken())));
            R.add(new Pair(i, Integer.parseInt(st.nextToken())));
        }
        Collections.sort(L);
        Collections.sort(R);
        int X = -2, Y = -2, min = Integer.MAX_VALUE;
        if (gap < 0) {
            X = Y = -1;
            min = B;
        }
        for (int i = 0; i < N; i++) {
            int idx = solve(L.get(i).idx, L.get(i).score, R);
            if (idx == -2)
                continue;
            int score = B + L.get(i).score + (idx == -1 ? 0 : R.get(idx).score);
            if (score < min) {
                X = L.get(i).idx;
                Y = idx == -1 ? -1 : R.get(idx).idx;
                min = score;
            }
        }
        for (int i = 0; i < N; i++) {
            int idx = solve(R.get(i).idx, R.get(i).score, L);
            if (idx == -2)
                continue;
            int score = B + R.get(i).score + (idx == -1 ? 0 : L.get(idx).score);
            if (score < min) {
                X = idx == -1 ? -1 : L.get(idx).idx;
                Y = R.get(i).idx;
                min = score;
            }
        }
        if (X == -2) {
            System.out.println("No");
            return;
        }
        System.out.printf("%d %d", X, Y);
    }
}

class Pair implements Comparable<Pair> {
    int idx, score;

    Pair(int idx, int score) {
        this.idx = idx;
        this.score = score;
    }

    @Override
    public int compareTo(Pair o) {
        return this.score - o.score;
    }
}
