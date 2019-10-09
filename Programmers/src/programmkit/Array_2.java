package programmkit;

import java.util.Arrays;
import java.util.Comparator;

/* 가장 큰 수
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수
 */
public class Array_2 {
	public static void main(String[] args) {
		int numbers[] = {3,30,34,5,9};
		String answer = solution(numbers);
		System.out.println(answer);
	}

	private static String solution(int[] numbers) {
		//int배열 >String배열로 변환
		String numberST[] = new String[numbers.length];
		for(int x=0; x<numbers.length; x++) {
			numberST[x] = String.valueOf(numbers[x]);
		}//int + "" 형식으로 int>String 하는건 효율 매우 안좋다.
		//String.valueof() 쓸 것!
		
		//2개 더하여 더 큰 쪽이 우선순위 있도록 정렬
//		Arrays.sort(numberST, new Comparator<String>() {
		//comparator : 기본 정렬기준 외에 다른 기준으로 정렬하고자 할 때
//
//			@Override
//			public int compare(String o1, String o2) {
//				return (o2+o1).compareTo(o1+o2);
//			}
//		});
		Arrays.sort(numberST, (o1,o2)->(o2+o1).compareTo(o1+o2));
		
		//0000처럼 0으로만 구성되어있으면 0 return
		if(numberST[0].equals("0"))
			return "0";
		
		//그 외의 경우 순차적으로 연결하여 answer return
//		String answer = "";
//		for(int x=0; x<numberST.length; x++) {
//			answer += numberST[x];
//		}
//		return answer;
		StringBuffer sb = new StringBuffer();
		for(int x=0; x<numberST.length; x++) {
			sb.append(numberST[x]);
		}
		return sb.toString();
	}
}
