import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int n, m;
	private static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int[] pick = new int[m];
		boolean[] vis = new boolean[10001];
		
		permutation(0, pick, vis);
	}
	
	private static void permutation(int depth, int[] pick, boolean[] vis) {
		if (depth == m) {
			for (int i = 0; i < m; i++)
				System.out.print(pick[i] + " ");
			System.out.println();
			
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (vis[arr[i]])
				continue;
			
			vis[arr[i]] = true;
			pick[depth] = arr[i];
			
			permutation(depth+1, pick, vis);
			
			vis[arr[i]] = false;
		}
	}
}
