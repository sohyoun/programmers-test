package programmkit;

import java.util.ArrayList;
import java.util.List;

/* 숫자 야구
 * 2명이 서로가 생각한 숫자를 맞추는 게임
 * 각자 서로 다른 1~9까지 3자리 숫자 정한 뒤 서로에게 3자리의 숫자 불러 결과 확인
 * 그 결과 토대로 상대가 정한 숫자 맞힘
 * 
 * 숫자 맞음, 위치 틀림 > 볼
 * 숫자와 위치 모두 맞음 > 스트라이크
 * 숫자와 위치 모두 틀림 > 아웃
 * 
 * 질문한 세자리 수, 스트라이크 수, 볼 수 담은 2차원 배열 baseball 주어짐
 * 가능한 답의 개수 return
 * */
public class BruteForce_3 {
	public static void main(String[] args) {
		int baseball[][] = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		int answer = solution(baseball);
		System.out.println(answer);
	}

	private static int solution(int[][] baseball) {
		int answer = 0;
		//baseball의 숫자들 String으로
		String baseST[] = new String[baseball.length];
		for(int x=0;x<baseball.length;x++) {
			baseST[x]=String.valueOf(baseball[x][0]);
		}
		
		//3자리 숫자 가능한 거 다 순열에 때려박기
		//1~9 9*8*7 = 504
		List<String> numlist = new ArrayList<String>();
		int num = 0;
		for(int x=1; x<10; x++) {//1
			num += (x*100);//100
			for(int y=1;y<10;y++) {//2
				if(y!=x) {
					num+=(y*10);//120
					for(int z=1;z<10;z++) {
						if(z!=y&&z!=x) {
							num+=z;
							numlist.add(String.valueOf(num));
							num-=z;
						}
					}
					num-=(y*10);
				}
			}
			num-=(x*100);
		}
//		for(int x=0;x<504;x++) {
//			System.out.println(numlist.get(x));
//		}
		
		int strike = 0;
		int ball = 0;
		//baseball과 비교해서 맞는 것은 남기고 틀린것은 0으로
		for(int x=0; x<baseball.length; x++) {//123 356  327 489
			for(int y=0; y<504; y++) {//numlist  324
				if(numlist.get(y)!="0") {//numlist 0이 아니라면
					for(int z=0; z<3; z++) {//numlist의 자리수 비교
						for(int j=0; j<3; j++) {//baseST의 자리수 비교
//							numlist.get(y).charAt(z);
//							baseST[x].charAt(j);
							if(numlist.get(y).charAt(z)==baseST[x].charAt(j)) {
								//2						
								if(z==j) {
									strike++;
								} else {
									ball++;//1
								}
							}
						}
					}
					//strike ball계산 다 끝남
					if(!(baseball[x][1]==strike && baseball[x][2]==ball)) {
						//틀리다면
						numlist.set(y, "0");
					}
					strike = 0;
					ball = 0;
				}
				
			}
		}
		
		//0이 아닌 것의 개수 return
		for(int x=0;x<504;x++) {
			if(!numlist.get(x).equals("0")) {
				answer++;
				//System.out.println(numlist.get(x));
			}
		}
		return answer;
	}
}
