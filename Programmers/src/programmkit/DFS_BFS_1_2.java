package programmkit;

public class DFS_BFS_1_2 {
	public static void main(String[] args) {
		int numbers[] = {1,1,1,1,1};
		int target = 3;
		int answer = new DFS_BFS_1_2().solution(numbers, target);
		System.out.println(answer);
	}

	public int solution(int[] numbers, int target) {
		
		return DFS(numbers, target, 0, 0);
	}

	public int DFS(int[] numbers, int target, int index, int num) {
		//index : numbersÀÇ index
		//num   : ÃÑ ÇÕ
		if(index==numbers.length) {
			return num == target ? 1:0;
			//³¡±îÁö °¬À» ¶§ ÃÑÇÕÀÌ targetÀÌ¶û °°À¸¸é 1
		} else {
			return DFS(numbers, target, index+1, num+numbers[index])
					+DFS(numbers, target, index+1, num-numbers[index]);
		}
	}
}
