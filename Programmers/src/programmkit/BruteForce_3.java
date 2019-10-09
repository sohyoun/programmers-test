package programmkit;

import java.util.ArrayList;
import java.util.List;

/* ���� �߱�
 * 2���� ���ΰ� ������ ���ڸ� ���ߴ� ����
 * ���� ���� �ٸ� 1~9���� 3�ڸ� ���� ���� �� ���ο��� 3�ڸ��� ���� �ҷ� ��� Ȯ��
 * �� ��� ���� ��밡 ���� ���� ����
 * 
 * ���� ����, ��ġ Ʋ�� > ��
 * ���ڿ� ��ġ ��� ���� > ��Ʈ����ũ
 * ���ڿ� ��ġ ��� Ʋ�� > �ƿ�
 * 
 * ������ ���ڸ� ��, ��Ʈ����ũ ��, �� �� ���� 2���� �迭 baseball �־���
 * ������ ���� ���� return
 * */
public class BruteForce_3 {
	public static void main(String[] args) {
		int baseball[][] = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		int answer = solution(baseball);
		System.out.println(answer);
	}

	private static int solution(int[][] baseball) {
		int answer = 0;
		//baseball�� ���ڵ� String����
		String baseST[] = new String[baseball.length];
		for(int x=0;x<baseball.length;x++) {
			baseST[x]=String.valueOf(baseball[x][0]);
		}
		
		//3�ڸ� ���� ������ �� �� ������ �����ڱ�
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
		//baseball�� ���ؼ� �´� ���� ����� Ʋ������ 0����
		for(int x=0; x<baseball.length; x++) {//123 356  327 489
			for(int y=0; y<504; y++) {//numlist  324
				if(numlist.get(y)!="0") {//numlist 0�� �ƴ϶��
					for(int z=0; z<3; z++) {//numlist�� �ڸ��� ��
						for(int j=0; j<3; j++) {//baseST�� �ڸ��� ��
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
					//strike ball��� �� ����
					if(!(baseball[x][1]==strike && baseball[x][2]==ball)) {
						//Ʋ���ٸ�
						numlist.set(y, "0");
					}
					strike = 0;
					ball = 0;
				}
				
			}
		}
		
		//0�� �ƴ� ���� ���� return
		for(int x=0;x<504;x++) {
			if(!numlist.get(x).equals("0")) {
				answer++;
				//System.out.println(numlist.get(x));
			}
		}
		return answer;
	}
}
