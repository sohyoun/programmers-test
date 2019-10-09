package programmkit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* 베스트앨범
 * 장르별로 가장 많이 재생된 노래를 두개씩 모아 베스트 앨범 출시
 * <규칙>
 * 노래는 고유 번호로 구분
 * 속한 노래가 많이 재생된 장르를 먼저 수록
 * 장르 내에서 많이 재생된 노래를 먼저 수록
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래 먼저 수록
 * 
 * 노래 장르 문자열 배열 genres
 * 노래별 재생 횟수 정수 배열 plays
 * 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return
 * */
public class Hash_4 {
	public static void main(String[] args) {
		String genres[] = { "classic", "pop", "classic", "classic", "pop" };
		int plays[] = { 500, 600, 150, 800, 2500 };

		Object[] answer = solution(genres, plays);
		for(int x=0; x<answer.length;x++) {
			//System.out.println(answer[x]);
		}
	}

	private static Object[] solution(String[] genres, int[] plays) {
		//genres.length
		int size = genres.length;
		//int answer[] = new int[plays.length];
		List<Integer> answer = new ArrayList<Integer>();
		
		// genres와 plays arraylist로 변형
		List<String> gen = new ArrayList<String>();
		List<Integer> pla = new ArrayList<Integer>();
		for(int x=0; x<size; x++) {
			gen.add(genres[x]);
			pla.add(plays[x]);
			//System.out.println(gen.get(x)+"--"+pla.get(x));
		}

		// music : plays 총 합 (key-genres/value-plays총합
		HashMap<String, Integer> music = new HashMap<String, Integer>();
		int i = 0;
		for (int x = 0; x<size; x++) {
			if (!music.containsKey(genres[x])) {
				music.put(genres[x], plays[x]);
			} else {
				i = music.get(genres[x]);
				music.put(genres[x], plays[x] + i);
			}
		}

		// music을 value값으로 정렬
		List<String> list = new ArrayList<String>();
		list.addAll(music.keySet());
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int ob1 = music.get(o1);
				int ob2 = music.get(o2);
				return ((Comparable<Integer>) ob2).compareTo(ob1);
			}
		});
		Iterator it = list.iterator();
		int before = 0;
		int after = 0;
		
		//가장 많이 재생된 노래 두개씩 모아!
		while (it.hasNext()) {
			String key = (String) it.next();//pop
			//System.out.println(key + "-" + music.get(key));
			before = answer.size();//0
			for(int x=0; x<size; x++) {
				if(gen.get(x).equals(key)) {
					answer.add(x);//1,4
				}
			}
//			for(int y=0; y<answer.size();y++) {
//				System.out.println("    "+answer.get(y));//1,4
//			}
			after = answer.size();//2
			if(after-before>=2) {//2
				//value값에 따라 정렬
				Arrays.sort(answer.toArray(), before, after, new Comparator<Object>() {
					
					@Override
					public int compare(Object o1, Object o2) {//o1:4,o1:1
						int r1 = pla.get((int)o2);//2500
						//System.out.println(r1);
						int r2 = pla.get((int)o1);//600
						//System.out.println(r2);
//						if(r1<r2) {
//							return r2;
//						} else {
//							return r1;
//						}
						
						return ((Comparable<Integer>) r2).compareTo(r1);
					}
					
				});
				
				//after-before-2 만큼 뒤에껀 remove
				//pop은 1,4 classic은 0,2,3
				for(int y=0; y<answer.size();y++) {
					System.out.println(answer.get(y));
				}
				
			}
			
			
		}
		
		return answer.toArray();
	}
}

/*
 * Hash map 정렬 -Key에 의한 정렬 : TreeMap 사용 TreeMap<String,Integer> tm = new
 * TreeMap<String, Integer>(hashmap); Iterator<String> keysort =
 * tm.keySet().iterator(); while(keysort.hasNext()) { String key =
 * keysort.next(); sysout~key }
 * 
 * -Value에 의한 정렬 : key목록을 list에 담고 해당 list를 value 기준으로 정렬
 * 
 * List<String> list = new ArrayList(); list.addAll(hashmap.keySet());
 * Collections.sort(list, new Comparator() {
 * 
 * @Override public int compare(Object o1, Object o2) { Object ob1 =
 * hashmap.get(o1); Object ob2 = hashmap.get(o2); return ((Comparable)
 * ob2).compareTo(ob1); } }); //내림차순 하려면 Collections.reverse(list); Iterator
 * iterator = list;
 * 
 */
