package programmkit;

/* Ÿ�� �ѹ�
 * n���� ���� �ƴ� ������ �ִ�. 
 * �� ���� ������ ���ϰų� ���� Ÿ�� �ѹ� ������� �Ѵ�.
 * 
 * ���� ��� �迭 numbers, Ÿ�� �ѹ� target �Ű������� �־���
 * ���� ������ ���ϰ� ���� Ÿ�� �ѹ� ����� ��� �� return
 * */
public class DFS_BFS_1 {
//���� Ž�� DFS �����..
//DFS�� Stack �Ǵ� ��͸� ���� Ǯ�� ����
//�迭�� �ִ� ��Ұ� �ϳ��� ���, �迭�� �ε����� ����
//�ᱹ �� ���̿� ���� ��� Ž����, ��� ����� �� Ž��!
//DFS�� ��ȭ�İ� �������� ã�� ���� ���� �߿�.
//���������� ��� ����,�� �迭�� ��� ��ҿ� �������� ��
//��ȭ���� �ش� �ε����� ��Ҹ� ������, �������������� ��� ��츦 ������!�̴�.
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
		if(index == numbers.length) {//�� ���Ҵٸ�(��������)
			return num == target ? 1:0;
		} else {
			return DFS(numbers, target, index+1, num+numbers[index])
					+ DFS(numbers, target, index+1, num - numbers[index]);
		}
	}
}
