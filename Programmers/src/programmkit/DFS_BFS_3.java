package programmkit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 단어 변환
 * 두개의 단어 begin, target과 단어의 집합 words가 있습니다.
 * 규칙을 이용해서 begin에서 target으로 변환하는 가장 짧은 변환 방법을 찾으려합니다.
 * 
 * 규칙 1. 한번에 한개의 알파벳만 바꿀 수 있다.
 * 규칙 2. words에 있는 단어로만 변환 가능.
 * 
 * begin과 target은 같지 않음
 * words에는 중복되는 단어 없음
 * 변환 불가 경우에는 0 return
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
