package programmkit;


/* 카펫
 * leo는 카펫을 사러 갔다가 중앙은 빨강, 모서리는 갈색으로 칠해진 격자 모양 카펫을 봤다
 * 집에 돌아와 아까 본 카펫의 빨간색과 갈색으로 색칠된 격자의 개수는 기억했지만 전체 카펫 크기는 기억이 안난다.
 * 
 * leo가 본 카펫에서 갈색 격자 수 brown, 빨간색 격자 수 red 주어질 때
 * 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return
 * (카펫의 가로길이는 세로랑 같거나 더 길다)
 * */
public class BruteForce_4 {
	public static void main(String[] args) {
		int brown = 24;
		int red = 24;
		/*
		b b b b b
		b r r r b
		b r r r b
		b b b b b
		
		b b b b b b
		br r r r r rb
		b b b b b b
		*/
		int answer[] = solution(brown, red);
		System.out.println("dap : "+answer[0]+","+answer[1]);
	}

	private static int[] solution(int brown, int red) {
		//red의 가능한 배열 2X3 or 1X6
		//>>brown 갯수  2X2+3X2+4
		int answer[] = new int[2];
		
		int garo = 0;
		int sero = 0;
		int bnum = 0;
		for(int x=1; x<=Math.sqrt(red); x++) {
			if(red%x==0) {
				sero = x;
				garo = red/x;
				//System.out.println("세로 : " + sero + " / 가로 : " + garo);
				bnum = (sero+garo)*2+4;
				if(bnum==brown) {
					//System.out.println(brown);
					answer[0] = garo+2;
					answer[1] = sero+2;
					break;
				}
			}
		}
		return answer;
	}
}
