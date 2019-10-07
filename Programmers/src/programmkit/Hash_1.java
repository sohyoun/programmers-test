package programmkit;

import java.util.Arrays;

/* 완주하지 못한 선수
 * 단 한명의 선수 제외하고 모든 선수 마라톤 완주
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름 담긴 배열 completion 주어질 때,
 * 완주하지 못한 선수의 이름 return
 * */
public class Hash_1 {
	public static void main(String[] args) {
		String participant[] = { "mislav", "stanko", "mislav", "ana" };
		String completion[] = { "stanko", "ana", "mislav" };
		String answer = solution(participant, completion);
		System.out.println(answer);
	}

	private static String solution(String[] participant, String[] completion) {
		Arrays.sort(participant);
		Arrays.sort(completion);
		int comsize = completion.length;
		for (int x = 0; x < comsize; x++) {
			if(!participant[x].equals(completion[x])) {
				return participant[x];
			} 
		}
		return participant[comsize];
		
		/*
		String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
		*/
	}
}
