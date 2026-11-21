import java.io.*;
import java.util.*;


public class Main {
	
	private static int n, m;
	private static boolean[] vis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		vis = new boolean[n+1];
		
		List<Integer> list = new ArrayList<>();
		
		permutation(0, list);
		
	}
	
	private static void permutation(int depth, List<Integer> list) {
		if (depth == m) {
			for (int i = 0; i < m; i++)
				System.out.print(list.get(i) + " ");
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if (vis[i])
				continue;
			
			vis[i] = true;
			list.add(i);
			
			permutation(depth+1, list);
			
			list.remove(list.size()-1);
			vis[i] = false;
		}
	}
	
}