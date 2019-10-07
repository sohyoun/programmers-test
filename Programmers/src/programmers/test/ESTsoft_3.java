package programmers.test;

public class ESTsoft_3 {
	public static void main(String[] args) {
		int U = 3;
		int L = 2;
		int[] C = {2,1,1,0,1};
		String answer = solution(U,L,C);
		System.out.println(answer);
	}
	public static String solution(int U, int L, int[] C) {
        // write your code in Java SE 8
		int N = C.length;//5
		int M[][] = new int[2][N];
		int sum = 0;
		for(int x=0; x<N; x++) {
			sum += C[x];
		}
		if(sum!=U+L) {
			return "IMPOSSIBLE";
		}
		for(int x=0; x<N; x++) {
			if(C[x] == 2) {
				M[0][x] = 1;
				M[1][x] = 1;
				U--;
				L--;
			} else if(C[x]==0) {
				M[0][x] = 0;
				M[1][x] = 0;
			} else {//2,1
				if(U>0) {
					M[0][x] = 1;
					M[1][x] = 0;
					U--;
				}else if(L>0) {
					M[0][x] = 0;
					M[1][x] = 1;
					L--;
				}
			}
		}
		if(U==0 && L==0) {
			StringBuffer sb = new StringBuffer();
			for(int x=0;x<N;x++) {
				sb.append(M[0][x]);
			}
			sb.append(",");
			for(int x=0;x<N;x++) {
				sb.append(M[1][x]);
			}
			return sb.toString();
		}
		
		
		
		return "";
    }
}
