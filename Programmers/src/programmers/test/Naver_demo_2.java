package programmers.test;

public class Naver_demo_2 {
	public static void main(String[] args) {
		char equip[][] = {{'#','#','#','#','#','#'},{'>','#','*','#','#','#'},{'#','#','#','#','*','#'},{'#','<','#','>','>','#'},{'>','#','*','#','*','<'},{'#','#','#','#','#','#'}};
		//equip : NXN 배열
		int result[] = solution(equip);//떨어지는위치
		for(int x=0; x<result.length; x++) {
			System.out.println(result[x]);
		}
	}
	
	public static int[] solution(char equip[][]) {
		int result[] = new int[equip.length];//6
		int sero = 0;//세로 count
		int garo = 0;//가로 count
		int countstar =0;//* count
		//System.out.println(equip[0][0]);
		for(int x=0; x<equip.length; x++) {
			garo = x;
			while(sero != equip.length-1) { // 다 떨어질때까지!!
				switch (equip[sero][garo]) {
				case '#': sero ++; break;
				case '>': garo ++; break;
				case '<': garo --; break;
				case '*': 
					countstar ++;
					switch (countstar) {
					case 1: sero ++; break;
					case 2: garo = -1; sero = equip.length-1;  break;
					}
				break;
				
				}
			}
			if(garo != -1) {//중간에 멈춘게 아니라면
				result[x] = garo;
				//System.out.println(result[x]);
			} else {
				result[x] = -1;
			}
			
			//초기화
			garo=0;
			sero=0;
			countstar=0;
		}
		return result;
	}
}
