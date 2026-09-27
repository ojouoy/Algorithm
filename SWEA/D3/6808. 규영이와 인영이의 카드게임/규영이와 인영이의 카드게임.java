import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    private static int gyuWin;
    private static int inWin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            int[] gyu = new int[9];
            int[] in = new int[9];
            boolean[] isUsed = new boolean[19];   // 규영이가 선택한 카드인지

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                gyu[i] = Integer.parseInt(st.nextToken());
                isUsed[gyu[i]] = true;
            } // 규영이 카드 선택 끝

            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (isUsed[i])
                    continue;
                in[idx++] = i;
            } // 인영이 카드 선택 끝

            // 높은 수가 적힌 카드를 낸 사람은 두 카드에 적힌 수의 합만큼 점수를 얻고
            // 낮은 수가 적힌 카드를 낸 사람은 아무런 점수도 얻을 수 없다.
            boolean[] inUsed = new boolean[9];   // 순열 생성할 때 인영이 사용한 카드인지 확인

            gyuWin = 0; inWin = 0;
            permutation(0, gyu, in, inUsed, 0, 0);

            sb.append(gyuWin).append(" ").append(inWin).append("\n");
        }

        System.out.println(sb);
    }

    private static void permutation(int depth, int[] gyu, int[] in, boolean[] inUsed, int gyuScore, int inScore) {
        if (depth == 9) {
            if (gyuScore > inScore)
                gyuWin++;
            else
                inWin++;
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (inUsed[i])
                continue;

            int nextGyu = gyuScore;
            int nextIn = inScore;

            if (gyu[depth] > in[i])
                nextGyu += gyu[depth] + in[i];
            else if (gyu[depth] < in[i])
                nextIn += gyu[depth] + in[i];

            inUsed[i] = true;
            permutation(depth+1, gyu, in, inUsed, nextGyu, nextIn);
            inUsed[i] = false;
        }
    }
}
