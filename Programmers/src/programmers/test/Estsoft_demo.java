package programmers.test;

import java.util.Arrays;

public class Estsoft_demo {
	public static void main(String[] args) {
		int A[] = {1,2,3};
		int answer = solution(A);
		System.out.println(answer);
	}
	public static int solution(int[] A) {
        // write your code in Java SE 8
		Arrays.sort(A);//1 1 2 3 4 6
		int len = A.length;
		for(int x=0; x<len; x++) {
			if(A[x]<=0) {
				return 1;
			}
		}
		for(int x=0; x<len-1; x++) {
			if(A[x+1]-A[x]>=2) {//4
				return A[x]+1;
			}
		}
		return A[len-1]+1;
    }
}
