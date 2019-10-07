package programmkit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* K번째 수
 * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, K번째 수
 * */
public class Array_1 {
	public static void main(String[] args) {
		int array[] = {1, 5, 2, 6, 3, 7, 4};
		int commands[][] = {{2,5,3},{4,4,1},{1,7,3}};
		
		int answer[] = solution(array, commands);
		for(int x=0; x<answer.length; x++) {
			System.out.println(answer[x]);
		}
	}

	private static int[] solution(int[] array, int[][] commands) {
		int[] newarray = new int[array.length];//1526374
		for(int x=0;x<newarray.length; x++) {
			newarray[x] = array[x];
		}
		int answer[] = new int[commands.length];
		int y=0;
		for(int x=0; x<commands.length; x++) {
			Arrays.sort(array, commands[x][0]-1, commands[x][1]);
			y= commands[x][0] + commands[x][2]-2;
			answer[x] = array[y];
			for(int z=0; z<array.length; z++) {
				array[z] = newarray[z];
			}
		}
		
		return answer;
		
		
		/*
		int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
		 */
	}
	
	
}
