package programmkit;

import java.util.Arrays;
import java.util.Comparator;

/* ���� ū ��
 * 0 �Ǵ� ���� ������ �־����� ��, ������ �̾� �ٿ� ���� �� �ִ� ���� ū ��
 */
public class Array_2 {
	public static void main(String[] args) {
		int numbers[] = {3,30,34,5,9};
		String answer = solution(numbers);
		System.out.println(answer);
	}

	private static String solution(int[] numbers) {
		//int�迭 >String�迭�� ��ȯ
		String numberST[] = new String[numbers.length];
		for(int x=0; x<numbers.length; x++) {
			numberST[x] = String.valueOf(numbers[x]);
		}//int + "" �������� int>String �ϴ°� ȿ�� �ſ� ������.
		//String.valueof() �� ��!
		
		//2�� ���Ͽ� �� ū ���� �켱���� �ֵ��� ����
//		Arrays.sort(numberST, new Comparator<String>() {
		//comparator : �⺻ ���ı��� �ܿ� �ٸ� �������� �����ϰ��� �� ��
//
//			@Override
//			public int compare(String o1, String o2) {
//				return (o2+o1).compareTo(o1+o2);
//			}
//		});
		Arrays.sort(numberST, (o1,o2)->(o2+o1).compareTo(o1+o2));
		
		//0000ó�� 0���θ� �����Ǿ������� 0 return
		if(numberST[0].equals("0"))
			return "0";
		
		//�� ���� ��� ���������� �����Ͽ� answer return
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
