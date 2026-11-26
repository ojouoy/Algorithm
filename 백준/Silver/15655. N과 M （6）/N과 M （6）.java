import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int n, m;
	private static int[] arr, pick;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());   // 총 n개
		m = Integer.parseInt(st.nextToken());   // 중에서 m개 선택
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		pick = new int[m];
		
		permutation(0, 0);
	}

	private static void permutation(int depth, int start) {
		if (depth == m) {
			for (int i = 0; i < m; i++)
				System.out.print(pick[i] + " ");
			System.out.println();
			
			return;
		}
		
		for (int i = start; i < n; i++) {
			pick[depth] = arr[i];
			permutation(depth+1, i+1);
		}
		
	}
}
