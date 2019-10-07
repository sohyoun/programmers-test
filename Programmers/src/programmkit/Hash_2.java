package programmkit;

import java.util.Arrays;

/* 전화번호 목록
 * 전화번호 중, 한 번호가 다른 번호의 접두어인 경우 찾음
 * 접두어인 경우가 있으면 false/없으면 true 리턴
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
