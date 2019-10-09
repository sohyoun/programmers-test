package programmkit;

import java.util.*;


/* ���ǰ��
 * ������ 3��
 * 1�� : 1 2 3 4 5		�ݺ�
 * 2�� : 21 23 24 25		�ݺ�
 * 3�� : 33 11 22 44 55  �ݺ�
 * ���� �迭 answers �־����� ��, ���� ���� ���� ���� ���
 * 1���� �������� ��� return ���� �������� ����
 * */
public class BruteForce_1 {
	public static void main(String[] args) {
		int answers[] = { 1,2,3,4,5,4,2,5,2,1,2 };
		int dap[] = solution(answers);
		for(int x=0; x<dap.length; x++) {
			System.out.print(dap[x]+" ");
		}
	}

	private static int[] solution(int[] answers) {
		int spj1[] = { 1, 2, 3, 4, 5 };// 5
		int spj2[] = { 2, 1, 2, 3, 2, 4, 2, 5 };// 8
		int spj3[] = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };// 10
		
		List<Integer> list = new ArrayList<Integer>();
		for(int x=0; x<3;x++) {
			list.add(0);
		}
		
		for (int x = 0; x < answers.length; x++) {
			if (answers[x] == spj1[x % 5]) {
				list.set(0, list.get(0)+1);
			}
			if (answers[x] == spj2[x % 8]) {
				list.set(1, list.get(1)+1);
			}
			if (answers[x] == spj3[x % 10]) {
				list.set(2, list.get(2)+1);
			}

		}
		
		int max= Collections.max(list);
		
		
		List<Integer> maxlist = new ArrayList<Integer>();
		
		for(int x=0; x<list.size(); x++) {
			if(list.get(x)==max) {
				maxlist.add(x+1);
			}
		}

		int dap[] = new int[maxlist.size()];
		for(int y=0;y<dap.length; y++) {
			dap[y] = maxlist.get(y);
		}
		
		Arrays.sort(dap);
		return dap;
	}
}
