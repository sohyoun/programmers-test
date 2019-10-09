package programmkit;

import java.util.HashSet;

/* 소수 찾기
 * 한자리 숫자 적힌 종이조각 붙여 소수 몇개 만들 수 있는가
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers
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
		//011 >> 0,1,10,11,101,110 만들 수 있음..!
		//이 중 소수는 11,101>>return 2
		
		
		//char numarr[] = numbers.toCharArray();//String하나씩 짜르는 방법!!
		String[] numarr = numbers.split("");
		HashSet<Integer> checked = new HashSet<>();
		
		for(int i=0; i<numarr.length; i++) {
			answer += makeNum(numarr, checked, "", 0, i+1);
		}
		
		
		return answer;
	}
	
	//숫자 조합 생성하는 메소드
	private static int makeNum(String[] arr, HashSet<Integer> checked, String numString, int visited, int toPick) {

        if (toPick == 0) {
            int num = Integer.parseInt(numString);

            //중복검사
            if(checked.contains(num)) return 0;
            checked.add(num);
            //소수 판별
            if (isPrime(num)) return 1;
            return 0;
        }

        int ret = 0;

        //자기자신을 중복선택하지 않는 순열 생성 (visitied 사용여부에 따라)
        for (int i = 0; i < arr.length; i++) {
            if((visited & (1 << i)) > 0)
                continue;
            ret += makeNum(arr, checked, numString + arr[i], visited + (1 << i), toPick - 1);
        }
        
        return ret;
	}

	//소수인지 확인하는 함수
	private static boolean isPrime(int num) {
		if(num<2) return false;
		if(num==2) return true;//2,3
		
		for(int i=2; i<=Math.sqrt(num); i++) { //2~(자기자신)까지
			if(num%i == 0) {
				return false;
			}
		}
		return true;
	}
}

//소수인지 체크하는 방법//
//최대값이 101이라 치자
//		int num = 101;
//		int arr[] = new int[num-1];//100 >> 0~99 >> 2~101
//		
//		//2~101 넣기
//		for(int i=0; i<arr.length; i++) {
//			arr[i] = i+2;//2~101
//			//System.out.print(i+2+" ");
//		}

//1. 소수가 아닌 것들 모두 체크(에라토스테네스 방법)
//for(int i=2; i<arr.length+1; i++) {//나누는 값  i
//	for(int j=0; j<arr.length; j++) {
//		if(arr[j]!=i&&arr[j]%i==0) {//자신과 같지 않고 0으로 나눠떨어지면
//			//소수 아님
//			arr[j]=0; //소수 아닌 경우 0넣음
//		}
//	}
//}

//2. 체크 할 배수만큼만 반복문 돌게 함/0으로 체크된 수의 배수는 확인X
//for(int i=2; i<arr.length+1; i++) {//나누는 값  i
//	if(arr[i-2]==0)//이미 체크된 수의 배수는 확인 X
//		continue;
//	for(int j=i+i; j<arr.length+1;j+=i) {//i를 제외한 i의 배수 0체크
//		arr[j-2]=0;
//	}
//}
//3. 루트n까지만 체크하는 방법!(최상)
//for(int i=2; i<Math.sqrt(arr.length+1); i++) {//나누는 값  i
//	if(arr[i-2]==0)//0으로 체크됬다면 pass
//		continue;
//	for(int j=i+i; j<arr.length+1;j+=i) {//i를 제외한 i의 배수 0체크
//		arr[j-2]=0;
//	}
//}
