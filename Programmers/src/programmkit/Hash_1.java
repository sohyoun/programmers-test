package programmkit;

import java.util.Arrays;

/* �������� ���� ����
 * �� �Ѹ��� ���� �����ϰ� ��� ���� ������ ����
 * �����濡 ������ �������� �̸��� ��� �迭 participant�� ������ �������� �̸� ��� �迭 completion �־��� ��,
 * �������� ���� ������ �̸� return
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
