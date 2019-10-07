package programmers.test;



public class ESTsoft_1 {
	public static void main(String[] args) {
		String S = "bbaaaabbab";
		int answer = solution(S);
		System.out.println(answer);
	}
	public static int solution(String S) {
		int whereA=0;
		int whereB=0;
		while(S.contains("aaa")||S.contains("bbb")) {
			
			whereA = S.indexOf("aaa");
			//System.out.println(whereA);
			whereB = S.indexOf("bbb");
			if(whereA>=0&&whereA<=(S.length()/2-2)) {//앞쪽에 위치
				//S.length()//10 / 2 >>5
				StringBuffer sb = new StringBuffer(S);
				sb.replace(0, whereA + 3, "aa");
				S = sb.toString();
				System.out.println(S);
			}
			if(whereA>(S.length()/2-2)) {//뒤쪽에 위치
				//S.length()//10 / 2 >>5
				StringBuffer sb = new StringBuffer(S);
				sb.replace(whereA, whereA + 3, "aa");
				S = sb.toString();
			}
			if(whereB>=0&&whereB<=(S.length()/2-2)) {//앞쪽
				StringBuffer sb = new StringBuffer(S);
				sb.replace(0, whereB + 3, "bb");
				S = sb.toString();
			}
			if(whereB>(S.length()/2-2)) {
				StringBuffer sb = new StringBuffer(S);
				sb.replace(whereB, whereB + 3, "bb");
				S = sb.toString();
			}
		}
		System.out.println(S);
		
		return S.length();
    }
}
