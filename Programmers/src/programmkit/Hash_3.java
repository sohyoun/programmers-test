package programmkit;

//import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

/* 위장
 * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
 * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때
 * 서로 다른 옷의 조합의 수를 return
 * */
public class Hash_3 {
	public static void main(String[] args) {
		String clothes[][] = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		int answer = solution(clothes);
		System.out.println(answer);
	}

	private static int solution(String[][] clothes) {
		Hashtable<String, Integer> hasharr = new Hashtable<String, Integer>();
		int val = 0;
		for (int x = 0; x < clothes.length; x++) {
			if (!hasharr.containsKey(clothes[x][1])) {
				hasharr.put(clothes[x][1], 1);
			} else {
				val = hasharr.get(clothes[x][1]);
				hasharr.put(clothes[x][1], val + 1);
			}
		}
//		Collection<Integer> coll = hasharr.values();
//		Object[] arr = coll.toArray();
//		int answer = 1;
//		for (int x = 0; x < hasharr.size(); x++) {
//			answer *= (int) arr[x] + 1;
//
//		}
		int answer = 1;
		Iterator<Integer> it = hasharr.values().iterator();
		while(it.hasNext()) {
			answer *= it.next().intValue() + 1;
		}
		return answer - 1;
	}
}
