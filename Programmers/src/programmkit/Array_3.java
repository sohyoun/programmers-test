package programmkit;

import java.util.Arrays;

/* H-Index
 * �����ڰ� ��ǥ�� �� n�� ��, h�� �̻� �ο�� ���� h�� �̻��̰�
 * ������ ���� h�� ���� �ο�Ǿ��ٸ� h�� �� �������� H-Index�̴�.
 * */
public class Array_3 {
	public static void main(String[] args) {
		int citations[] = {3, 0, 6, 1, 5};
		
		int answer = solution(citations);
		System.out.println(answer);
	}

	private static int solution(int[] citations) {
		Arrays.sort(citations);
		int size = citations.length;
		int answer = 0;
		for(int x=0; x<size; x++) {
			if(citations[x]>=size-x) {
				answer = size-x;
				break;
			}
		}
		
		return answer;
	}
}
