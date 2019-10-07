package programmers.test;

public class Kakaotest1 {
	public static void main(String[] args) {
		int[][] v = {{1,4},{3,4},{3,10}};
		
		int[] answer = solution(v);
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		String word = "hello?";
		System.out.println(word.length());
//		System.out.println(word.charAt(6));
		if(word.charAt(5) == '?') {
			System.out.println("okkk");
		}
		
	}

	public static int[] solution(int[][] v) {
//		System.out.println(v.length);
		int[] answer = {0,0};
		for (int x=0; x<3; x++) {
			if (v[x%3][0] != v[(x+1)%3][0] && v[x%3][0] != v[(x+2)%3][0]) {
					answer[0] = v[x%3][0];
			}
			if (v[x%3][1] != v[(x+1)%3][1] && v[x%3][1] != v[(x+2)%3][1]) {
					answer[1] = v[x%3][1];					
			}
		}

		return answer;
	}
}
