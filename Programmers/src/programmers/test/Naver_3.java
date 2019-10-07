package programmers.test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Naver_3 {
	public static void main(String[] args) {
		int cook_times[] = {5, 30, 15, 30, 35, 20, 4};
		int order[][] = {{2,4},{2,5},{3,4},{3,5},{1,6},{4,6},{5,6},{6,7}};
		int k= 6;
		int result[] = solution(cook_times,order,k);
	}
	public static int[] solution(int cook_times[],int order[][], int k) {
		int result[] = new int[2];
		
		int inst[] = new int[order.length];//dic
		for(int x=0; x<order.length; x++) {
			inst[x] = order[x][0];
		}
		
		int time[] = new int[cook_times.length];//total time
		for(int x=0; x<cook_times.length; x++) {
			if(inst.length ==0) {
				time[x] = cook_times[x];
			} else {
				int large[] = new int[cook_times.length];//big
				for(int y=0; y<inst.length; y++) {
					large[x] = time[y];
				}
				time[x] = max(large) + cook_times[x];
			}
		}
		int torder[];
		Deque q = Deque();
		q.add(torder);
		while(q) {
			int ins = q.pop();
			for(i=0;i<inst.length; i++) {
				if(torder[i])
			}
		}
		
		return result;
	}
}
