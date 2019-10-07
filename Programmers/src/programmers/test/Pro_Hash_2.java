package programmers.test;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Pro_Hash_2 {
	public static void main(String[] args) {
		String[] phone_book = {"119","97674223","1195524431"};
		boolean answer = solution(phone_book);
		System.out.println(answer);
	}
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);

        for(int x=0; x<phone_book.length-1; x++) {
        	
        	if(phone_book[x+1].startsWith(phone_book[x])) {
        		return false;
        	}
        }
        return answer;
    }
}
