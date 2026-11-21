import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static boolean[] vis;
    private static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        permutation(0, 1);
    }

    private static void permutation(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++)
                System.out.print(list.get(i) + " ");
            System.out.println();

            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);

            permutation(depth+1, i+1);

            list.remove(list.size()-1);
        }
    }
}
