package programmkit;

/* 네트워크
 * 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태
 * ex) A와 B가 연결되어있고 B와 C가 연결되어있다면 A와 C도 연결되어 정보 교환 가능
 * >> 따라서 A,B,C모두 같은 네트워크 상에 있는 것
 * 
 * 컴퓨터 개수 n, 연결에 대한 정보 2차원 배열 computers가 매개변수로 주어짐
 * 네트워크의 개수 return
 * 
 * 컴퓨터 개수 3 >>컴0,컴1,컴2
 * i번 컴과 j번 컴 연결되어있으면 computers[i][j]를 1로 표현(computers[i][i]는 항상 1)
 * */

/* 문제 풀이 방법
연결된 노드를 끝까지 찾아가는 형태이므로 DFS 재귀함수 사용!
computers 이차원 배열을 1차원씩 잘라서 재귀함수 호출


*/
public class DFS_BFS_2 {
	
	public static void main(String[] args) {
		int n=3;
		int computers[][] = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		
		int answer = new DFS_BFS_2().solution(n, computers);
		System.out.println(answer);
	}
	static boolean[][] link;
	public int solution(int n, int[][] computers) {
		int answer =0;
		link = new boolean[n][n];
		for(int i=0; i<n; i++) {
			if(!link[i][i]) {//false라면
				dfs(computers,i,n);
				answer++;
			}
		}
		return answer;
	}
	public void dfs(int[][] computers, int idx, int n) {
		for(int i=0; i<n; i++) {
			if(computers[idx][i] == 1 && !link[idx][i]) {
				link[idx][i] = link[i][idx] = true;
				dfs(computers,i,n);
			}
		}
	}
	
	
}
