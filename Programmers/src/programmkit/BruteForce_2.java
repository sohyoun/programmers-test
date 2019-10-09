package programmkit;

import java.util.HashSet;

/* �Ҽ� ã��
 * ���ڸ� ���� ���� �������� �ٿ� �Ҽ� � ���� �� �ִ°�
 * �� ���� ������ ���� ���ڰ� ���� ���ڿ� numbers
 * 
 * */
public class BruteForce_2 {
	public static void main(String[] args) {
		String numbers = "011";
		int answer = solution(numbers);
		System.out.println("answer = "+answer);
	}

	private static int solution(String numbers) {
		int answer = 0;
		//011 >> 0,1,10,11,101,110 ���� �� ����..!
		//�� �� �Ҽ��� 11,101>>return 2
		
		
		//char numarr[] = numbers.toCharArray();//String�ϳ��� ¥���� ���!!
		String[] numarr = numbers.split("");
		HashSet<Integer> checked = new HashSet<>();
		
		for(int i=0; i<numarr.length; i++) {
			answer += makeNum(numarr, checked, "", 0, i+1);
		}
		
		
		return answer;
	}
	
	//���� ���� �����ϴ� �޼ҵ�
	private static int makeNum(String[] arr, HashSet<Integer> checked, String numString, int visited, int toPick) {

        if (toPick == 0) {
            int num = Integer.parseInt(numString);

            //�ߺ��˻�
            if(checked.contains(num)) return 0;
            checked.add(num);
            //�Ҽ� �Ǻ�
            if (isPrime(num)) return 1;
            return 0;
        }

        int ret = 0;

        //�ڱ��ڽ��� �ߺ��������� �ʴ� ���� ���� (visitied ��뿩�ο� ����)
        for (int i = 0; i < arr.length; i++) {
            if((visited & (1 << i)) > 0)
                continue;
            ret += makeNum(arr, checked, numString + arr[i], visited + (1 << i), toPick - 1);
        }
        
        return ret;
	}

	//�Ҽ����� Ȯ���ϴ� �Լ�
	private static boolean isPrime(int num) {
		if(num<2) return false;
		if(num==2) return true;//2,3
		
		for(int i=2; i<=Math.sqrt(num); i++) { //2~(�ڱ��ڽ�)����
			if(num%i == 0) {
				return false;
			}
		}
		return true;
	}
}

//�Ҽ����� üũ�ϴ� ���//
//�ִ밪�� 101�̶� ġ��
//		int num = 101;
//		int arr[] = new int[num-1];//100 >> 0~99 >> 2~101
//		
//		//2~101 �ֱ�
//		for(int i=0; i<arr.length; i++) {
//			arr[i] = i+2;//2~101
//			//System.out.print(i+2+" ");
//		}

//1. �Ҽ��� �ƴ� �͵� ��� üũ(�����佺�׳׽� ���)
//for(int i=2; i<arr.length+1; i++) {//������ ��  i
//	for(int j=0; j<arr.length; j++) {
//		if(arr[j]!=i&&arr[j]%i==0) {//�ڽŰ� ���� �ʰ� 0���� ������������
//			//�Ҽ� �ƴ�
//			arr[j]=0; //�Ҽ� �ƴ� ��� 0����
//		}
//	}
//}

//2. üũ �� �����ŭ�� �ݺ��� ���� ��/0���� üũ�� ���� ����� Ȯ��X
//for(int i=2; i<arr.length+1; i++) {//������ ��  i
//	if(arr[i-2]==0)//�̹� üũ�� ���� ����� Ȯ�� X
//		continue;
//	for(int j=i+i; j<arr.length+1;j+=i) {//i�� ������ i�� ��� 0üũ
//		arr[j-2]=0;
//	}
//}
//3. ��Ʈn������ üũ�ϴ� ���!(�ֻ�)
//for(int i=2; i<Math.sqrt(arr.length+1); i++) {//������ ��  i
//	if(arr[i-2]==0)//0���� üũ��ٸ� pass
//		continue;
//	for(int j=i+i; j<arr.length+1;j+=i) {//i�� ������ i�� ��� 0üũ
//		arr[j-2]=0;
//	}
//}
