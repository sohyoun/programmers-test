package programmers.test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NHN_2 {
	// FQ = queue �󵵼� ���� ���� �� ���� ��ȯ
	// enqueue(x) = ���� ���� x �Է¹޾� FQ�� ����
	// dequeue() = FQ���� �󵵼� ���� ���� �� ��, ���� ���� enqueue�� �� ��ȯ�ϰ� ����
	// FQ��������� -1 ��ȯ
	public static void main(String[] args) throws NumberFormatException, IOException{
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 int num = 0;
		 num = Integer.parseInt(in.readLine());//����
         
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
			} else {//dequeue�� ��
				
			}
		}
		
		return "";
	}
}
