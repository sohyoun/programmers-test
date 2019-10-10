package programmkit;

/* 타겟 넘버
 * n개의 음이 아닌 정수가 있다. 
 * 이 수를 적절히 더하거나 빼서 타겟 넘버 만드려고 한다.
 * 
 * 숫자 담긴 배열 numbers, 타겟 넘버 target 매개변수로 주어짐
 * 숫자 적절히 더하고 빼서 타겟 넘버 만드는 방법 수 return
 * */
public class DFS_BFS_1 {
//깊이 탐색 DFS 써야함..
//DFS는 Stack 또는 재귀를 통해 풀이 가능
//배열에 있는 요소가 하나의 노드, 배열의 인덱스는 깊이
//결국 각 깊이에 대해 모두 탐색함, 모든 경우의 수 탐색!
//DFS는 점화식과 종료조건 찾는 것이 가장 중요.
//종료조건은 모든 깊이,즉 배열의 모든 요소에 접근했을 때
//점화식은 해당 인덱스의 요소를 더할지, 더하지않을지의 모든 경우를 구하자!이다.
	public static void main(String[] args) {
		int numbers[] = { 1, 1, 1, 1, 1 };
		int target = 3;
		int answer = new DFS_BFS_1().solution(numbers, target);
		System.out.println(answer);
	}

	private int solution(int[] numbers, int target) {
							  //index num
		return DFS(numbers, target, 0, 0);
	}

	private int DFS(int[] numbers, int target, int index, int num) {
		if(index == numbers.length) {//다 돌았다면(종료조건)
			return num == target ? 1:0;
		} else {
			return DFS(numbers, target, index+1, num+numbers[index])
					+ DFS(numbers, target, index+1, num - numbers[index]);
		}
	}
}
