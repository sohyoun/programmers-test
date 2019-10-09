package programmkit;


/* ī��
 * leo�� ī���� �緯 ���ٰ� �߾��� ����, �𼭸��� �������� ĥ���� ���� ��� ī���� �ô�
 * ���� ���ƿ� �Ʊ� �� ī���� �������� �������� ��ĥ�� ������ ������ ��������� ��ü ī�� ũ��� ����� �ȳ���.
 * 
 * leo�� �� ī�꿡�� ���� ���� �� brown, ������ ���� �� red �־��� ��
 * ī���� ����, ���� ũ�⸦ ������� �迭�� ��� return
 * (ī���� ���α��̴� ���ζ� ���ų� �� ���)
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
		//red�� ������ �迭 2X3 or 1X6
		//>>brown ����  2X2+3X2+4
		int answer[] = new int[2];
		
		int garo = 0;
		int sero = 0;
		int bnum = 0;
		for(int x=1; x<=Math.sqrt(red); x++) {
			if(red%x==0) {
				sero = x;
				garo = red/x;
				//System.out.println("���� : " + sero + " / ���� : " + garo);
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
