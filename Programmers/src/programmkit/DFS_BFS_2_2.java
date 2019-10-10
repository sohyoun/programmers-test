package programmkit;

public class DFS_BFS_2_2 {
	public static void main(String[] args) {
		int n = 3;
		int computers[][] = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

		int answer = new DFS_BFS_2_2().solution(n, computers);
		System.out.println(answer);
	}

	public int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] chk = new boolean[n]; // 3 false
		for (int i = 0; i < n; i++) { //0,1,2
			if (!chk[i]) {//false¶ó¸é 0(false)
				dfs(computers, chk, i);// dfs(com,chk,0)
				answer++;
			}
		}
		return answer;
	}

	void dfs(int[][] computers, boolean[] chk, int start) {
		chk[start] = true;//chk[0] = true //chk[1]=true
		for (int i = 0; i < computers.length; i++) {//0,1,2
			if (computers[start][i] == 1 && !chk[i]) {//com[0][1]==1&&chk[1]false
				dfs(computers, chk, i);//dfs(com,chk,1)
			}
		}
	}
}
