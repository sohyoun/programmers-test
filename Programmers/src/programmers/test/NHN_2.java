package programmers.test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NHN_2 {
	// FQ = queue 빈도수 가장 높은 수 부터 반환
	// enqueue(x) = 양의 정수 x 입력받아 FQ에 저장
	// dequeue() = FQ에서 빈도수 가장 높은 수 중, 가장 먼저 enqueue된 수 반환하고 제거
	// FQ비어있으면 -1 반환
	public static void main(String[] args) throws NumberFormatException, IOException{
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 int num = 0;
		 num = Integer.parseInt(in.readLine());//갯수
         
		 BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
		 String queue[] = new String[num];
		 for(int x=0; x<num; x++) {
			 queue[x] = in2.readLine();			 
		 }
		 
		 String answer = solution(num,queue);
	}
	public static String solution(int num, String[] queue) {
		StringTokenizer st = null;
		List<Integer> list = new ArrayList<Integer>();
		for(int x=0; x<num; x++) {
			st = new StringTokenizer(queue[x]);
			if(st.nextToken().equals("enqueue")) {
				list.add(Integer.parseInt(st.nextToken()));
			} else {//dequeue일 때
				
			}
		}
		
		return "";
	}
}
