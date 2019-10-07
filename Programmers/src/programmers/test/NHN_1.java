package programmers.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class NHN_1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int cardn = 5;
		String card = "ant bee dragonfly ant bee";
		solution(cardn,card);

//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int num = 0;
//		num = Integer.parseInt(in.readLine());// °¹¼ö
//
//		BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
//		String card = in.readLine();
//
//		solution(num, card);
	}

	public static void solution(int cardn, String card) {
		StringTokenizer st = new StringTokenizer(card);
		int cnt = st.countTokens();
		String cardarr[] = new String[cnt];
		for (int x = 0; x < cnt; x++) {
			cardarr[x] = st.nextToken();
		}
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		for (int x = 0; x < cnt; x++) {
			Integer v = hmap.get(cardarr[x]);
			if (v == null)
				hmap.put(cardarr[x], 1);
			else
				hmap.put(cardarr[x], v + 1);
		}
		int size = hmap.size();
//		int each = cardn/size;//5/3
		int ss = 0;
		int nn = 0;
		for (Map.Entry<String, Integer> e : hmap.entrySet()) {
//			e.getValue()
			if(ss==0) {
				ss = e.getValue();
			} else if(ss!=e.getValue()) {//221
				System.out.println("ff");
				nn++;
			}
			ss = e.getValue();
			System.out.println(e.getKey() + ":" + e.getValue());
		}
		if(nn==0) {
			System.out.println("Y");
			System.out.println(cardn);
			System.out.println(size);
		} else if(nn==1 && (cardn+1)%size==0) {
			System.out.println("Y");
			System.out.println(cardn+1);
			System.out.println(size);
		} else {
			System.out.println("N");
			System.out.println(cardn);
			System.out.println(size);
		}
//		if ((cardn + 1) % size != 0) {
//			System.out.println("N");
//			System.out.println(cardn);
//			System.out.println(size);
//
//		} else {
//			int eachnum = (cardn + 1) / size;// °¢ Ä«µå °¹¼ö 2
//			for (Map.Entry<String, Integer> e : hmap.entrySet()) {
//
//				if (e.getValue() == eachnum) {
//
//				} else if (e.getValue() == eachnum - 1) {
//					System.out.println("Y");
//					System.out.println(cardn + 1);
//					System.out.println(size);
//					return;
//				}
//
//				// System.out.println(e.getKey() + ":" + e.getValue());
//			}
//		}

	}
}
