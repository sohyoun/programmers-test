package programmkit;

import java.util.Arrays;

/* ��ȭ��ȣ ���
 * ��ȭ��ȣ ��, �� ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��� ã��
 * ���ξ��� ��찡 ������ false/������ true ����
 * */
public class Hash_2 {
	public static void main(String[] args) {
		String phone_book[] =  {"9","11111","222"};
		boolean answer = solution(phone_book);
		System.out.println(answer);
	}

	private static boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);
		for(int x=0; x<phone_book.length-1; x++) {
			if(phone_book[x+1].startsWith(phone_book[x])) {
				return false;
			}
		}
		return true;
	}
}
