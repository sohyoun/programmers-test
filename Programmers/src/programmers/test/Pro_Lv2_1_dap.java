package programmers.test;

import java.util.Arrays;

public class Pro_Lv2_1_dap {
	public static void main(String[] args) {
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };

		int[] answer = solution(progresses, speeds);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}

	}
	//람다식!
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {//0,1,2
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;//7 9 >>천잰디..?
        }
        for(int x=0; x<100; x++) {
        	System.out.print(dayOfend[x]);        	
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();//0인거 제외시키는 람다식!!!
    }
}
