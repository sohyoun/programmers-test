package programmers.test;

public class Naver_demo_2 {
	public static void main(String[] args) {
		char equip[][] = {{'#','#','#','#','#','#'},{'>','#','*','#','#','#'},{'#','#','#','#','*','#'},{'#','<','#','>','>','#'},{'>','#','*','#','*','<'},{'#','#','#','#','#','#'}};
		//equip : NXN �迭
		int result[] = solution(equip);//����������ġ
		for(int x=0; x<result.length; x++) {
			System.out.println(result[x]);
		}
	}
	
	public static int[] solution(char equip[][]) {
		int result[] = new int[equip.length];//6
		int sero = 0;//���� count
		int garo = 0;//���� count
		int countstar =0;//* count
		//System.out.println(equip[0][0]);
		for(int x=0; x<equip.length; x++) {
			garo = x;
			while(sero != equip.length-1) { // �� ������������!!
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
			if(garo != -1) {//�߰��� ����� �ƴ϶��
				result[x] = garo;
				//System.out.println(result[x]);
			} else {
				result[x] = -1;
			}
			
			//�ʱ�ȭ
			garo=0;
			sero=0;
			countstar=0;
		}
		return result;
	}
}
