package programmers.test;

import java.util.ArrayList;
import java.util.Arrays;

public class Pro_Hash_1 {
	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko","ana","mislav"};
		String answer = solution(participant,completion);
		System.out.println(answer);
	}

	public static String solution(String[] participant, String[] completion) {

		Arrays.sort(participant);//ana mislav mislav stanko
		Arrays.sort(completion); //ana mislav stanko

		int i;
		for(i=0;i<completion.length; i++) {
			if(!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}
		return participant[i];
	}
}
