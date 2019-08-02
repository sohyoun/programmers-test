package programmers.test;

import java.util.Arrays;

public class No1 {
	public static void main(String[] args) {
		int array[]= {1,5,2,6,3,7,4};
		int commands[][] = {{2,5,3},{4,4,1},{1,7,3}};
		int[] ans = {};
		ans = solution(array,commands);
		for(int z=0; z<ans.length; z++) {
			System.out.println(ans[z]);
		}
	}
	
	public static int[] solution(int[] array, int[][]commands) {
		int num = commands.length; //3
		int[] answer = new int[num];
		
		
		for(int i=0; i<num; i++) {
							
			int num1 = commands[i][0]-1;
			int num2 = commands[i][1]-1;
			int num3 = commands[i][2] - 1;
			
			int size = num2-num1+1;
			int[] newarray = new int[size]; 
			
			for(int x=0;x<size; x++) {
				newarray[x] = array[x+num1];
			}
			
			Arrays.sort(newarray);
			//System.out.println(newarray[num3]);
			answer[i] = newarray[num3];
		}
		return answer;
	}
}