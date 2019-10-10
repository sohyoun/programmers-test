package programmkit;

/* ��Ʈ��ũ
 * ��Ʈ��ũ�� ��ǻ�� ��ȣ ���� ������ ��ȯ�� �� �ֵ��� ����� ����
 * ex) A�� B�� ����Ǿ��ְ� B�� C�� ����Ǿ��ִٸ� A�� C�� ����Ǿ� ���� ��ȯ ����
 * >> ���� A,B,C��� ���� ��Ʈ��ũ �� �ִ� ��
 * 
 * ��ǻ�� ���� n, ���ῡ ���� ���� 2���� �迭 computers�� �Ű������� �־���
 * ��Ʈ��ũ�� ���� return
 * 
 * ��ǻ�� ���� 3 >>��0,��1,��2
 * i�� �İ� j�� �� ����Ǿ������� computers[i][j]�� 1�� ǥ��(computers[i][i]�� �׻� 1)
 * */

/* ���� Ǯ�� ���
����� ��带 ������ ã�ư��� �����̹Ƿ� DFS ����Լ� ���!
computers ������ �迭�� 1������ �߶� ����Լ� ȣ��


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
			if(!link[i][i]) {//false���
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
