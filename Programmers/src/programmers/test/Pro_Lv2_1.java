package programmers.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pro_Lv2_1 {
	public static void main(String[] args) {
		int[] progresses = { 30, 40, 50 };
		int[] speeds = { 1, 1, 1 };

		Object[] answer = solution(progresses, speeds);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}

	}

	public static Object[] solution(int[] progresses, int[] speeds) {
		int a = progresses.length;
		List<Integer> answer = new ArrayList<Integer>();
		int[] insanswer = new int[a];
		for (int x = 0; x < a; x++) {
			switch ((100 - progresses[x]) % speeds[x]) {
			case 0:
				insanswer[x] = (100 - progresses[x]) / speeds[x];
				break;

			default:
				insanswer[x] = (100 - progresses[x]) / speeds[x] + 1;
				break;
			}
			System.out.println(insanswer[x]); //70,60,50
			// 1,2,3 >> 1,1,1
			// 1,3,2 >> 1,2
			// 2,1,3 >> 2,1
			// 2,3,1 >> 1,2
			// 3,1,2 >> 3
			// 3,2,1 >> 3
		}
		int inst = 0;
		for (int x = 0; x < a - 1; x++) {
			if (insanswer[x] < insanswer[x + 1]) {
				inst = answer.get(x);
				answer.add(x, inst + 1);
			} else {
				inst = answer.get(x);
				answer.add(x, inst + 2);
			}
		}
		//1,1,1 ÇØ°á
		int sum = 0;
		for(int x=0; x<a; x++) {
			sum += answer.get(x);
		}
		if(sum != a) {
			answer.add(a-1, 1);
		}
		
		int count =0;
		for(int x=0; x<a; x++) {
			if(answer[x] ==0) {
				count ++;
			}
		}
		
		if(count != 0) {
			int answer2[] = new int[a-count];
			for(int x=0; x<a-count; x++) {
				answer2[x] = answer[x];
			}
			return answer2;
		}
		

		return answer;
	}

}
