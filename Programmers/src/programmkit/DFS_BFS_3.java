package programmkit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* �ܾ� ��ȯ
 * �ΰ��� �ܾ� begin, target�� �ܾ��� ���� words�� �ֽ��ϴ�.
 * ��Ģ�� �̿��ؼ� begin���� target���� ��ȯ�ϴ� ���� ª�� ��ȯ ����� ã�����մϴ�.
 * 
 * ��Ģ 1. �ѹ��� �Ѱ��� ���ĺ��� �ٲ� �� �ִ�.
 * ��Ģ 2. words�� �ִ� �ܾ�θ� ��ȯ ����.
 * 
 * begin�� target�� ���� ����
 * words���� �ߺ��Ǵ� �ܾ� ����
 * ��ȯ �Ұ� ��쿡�� 0 return
 * */
public class DFS_BFS_3 {
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String words[] = { "hot", "dot", "dog", "lot", "log", "cog" };
		int answer = new DFS_BFS_3().solution(begin, target, words);
		System.out.println(answer);
	}

	public int solution(String begin, String target, String[] words) {
		int answer = 0;

		List<String> wordList = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			wordList.add(words[i]);
		}

		answer = DFS(begin, target, wordList, 0);
		return answer;
	}

	public int DFS(String begin, String target, List<String> wordList, int stack) {
		int cheack = begin.length() - 1;
		for (int i = 0; i < wordList.size(); i++) {
			int count = 0;
			int targetcount = 0;
			for (int j = 0; j < begin.length(); j++) {
				if (begin.charAt(j) == wordList.get(i).charAt(j)) {
					count++;
				}
				if (begin.charAt(j) == target.charAt(j)) {
					targetcount++;
				}
			}
			if (targetcount == cheack) {
				stack++;
				return stack;
			}

			if (count == cheack) {
				begin = wordList.get(i);
				stack++;
				wordList.remove(i);
				return DFS(begin, target, wordList, stack);
			}
		}
		return 0;
	}

}
