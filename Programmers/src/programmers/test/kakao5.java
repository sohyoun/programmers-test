package programmers.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kakao5 {
	public static void main(String[] args) {
		int n =5;
		int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1}
								,{2,2,1,1},{5,0,0,1},{5,1,0,1}
								,{4,2,1,1},{3,2,1,1}};
		
		int[][] answer = solution(n,build_frame);
		System.out.println(answer.length);
		
	}
	public static int[][] solution(int n, int[][] build_frame) {
        
        int[] ins = new int[build_frame.length];
        int num = build_frame.length;
        for(int x=0; x<ins.length; x++) {
        	ins[x] = 0;
        }
        for(int x=0; x<build_frame.length-1; x++) {
        	for(int y=1; y<build_frame.length; y++) {
        		if(build_frame[x][0] == build_frame[y][0]) {
        			if(build_frame[x][1] == build_frame[y][1]) {
        				if(build_frame[x][2]==build_frame[y][2]) {
        					ins[x] = 1;
        					ins[y] = 1;
        					num -=1;
        				}
        			}
        		}
        		
        	}//같은거 지우기
        }
        System.out.println(num);
        int[][] answer = new int[num][3];
        int a = 0;
        for(int x=0; x<build_frame.length; x++) {
        	if(ins[x]==0) {
        		answer[a][0]=build_frame[x][0];
        		answer[a][1]=build_frame[x][1];
        		answer[a][2]=build_frame[x][2];
        		a++;
        	}
        }
        
        return answer;
    }
}
