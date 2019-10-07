package programmkit;

import java.util.Arrays;

/* H-Index
 * 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고
 * 나머지 논문이 h번 이하 인용되었다면 h가 이 과학자의 H-Index이다.
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
