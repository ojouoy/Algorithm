import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static StringBuilder sb;
	private static int n, m;
	private static int[] arr, pick;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
	
		Arrays.sort(arr);
		
		pick = new int[m];
		permutation(0);
		
		System.out.println(sb);
	}

	private static void permutation(int depth) {
		if (depth == m) {
			for (int i = 0; i < m; i++)
				sb.append(pick[i]).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < n; i++) {
			pick[depth] = arr[i];
			permutation(depth+1);
		}
	}
}
