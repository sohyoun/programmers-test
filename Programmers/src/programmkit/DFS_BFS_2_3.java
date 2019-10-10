package programmkit;

public class DFS_BFS_2_3 {
	public static void main(String[] args) {
		DFS_BFS_2_3 df = new DFS_BFS_2_3();
		int n = 3;
		int computers[][] = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		System.out.println(df.solution(n, computers));
		
		
	}

	public int solution(int n, int[][] computers) {
		int answer = 0;
		boolean check[] = new boolean[n];
		for(int x=0; x<n; x++) {
			if(!check[x]) {
				DFS(n, computers, check, x);
				answer++;				
			}
		}
		
		return answer;
	}

	private void DFS(int n, int[][] computers, boolean[] check, int index) {
		check[index] = true;
		for(int x=0; x<n; x++) {
			if(computers[index][x]==1 && !check[x]) {
				DFS(n, computers, check, x);
			}
		}
		
	}
}
