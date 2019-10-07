package programmers.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Naver_1 {
	public static void main(String[] args) {
		String record[] = {"RECEIVE abcd@naver.com", "RECEIVE zzkn@naver.com", "DELETE", "RECEIVE qwerty@naver.com", "SAVE", "SAVE", "DELETE", "RECEIVE QwerTY@naver.com", "SAVE"};

		String result[] = solution(record);

		for (int x = 0; x < result.length; x++) {
			System.out.println(result[x]);
		}
	}

	public static String[] solution(String record[]) {

		//String result[] = new String[10000];
		List<String> resultlist = new ArrayList<String>();
		String protocole = "";
		String email = "";
		List<String> instresult = new ArrayList<String>();//임시 보관함
		int size =0;
		for (int x = 0; x < record.length; x++) {
			StringTokenizer st = new StringTokenizer(record[x]);
			protocole = st.nextToken();
			//System.out.println(protocole);
			switch (protocole) {
			case "RECEIVE":
				email = st.nextToken();
				instresult.add(email);
				break;
			case "DELETE":
				size = instresult.size();
				//System.out.println(size);
				if(size>0) {
					instresult.remove(size-1);
				}
				break;
			case "SAVE":
				resultlist.addAll(instresult);
				for(int y=0; y<instresult.size(); y++) {
					instresult = new ArrayList<String>();
				}
				//System.out.println(instresult.size());
				break;
			}
		}
		size = resultlist.size();
		String result[] = resultlist.toArray(new String[size]);
		return result;
	}

}
