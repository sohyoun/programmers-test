package programmers.test;

public class kakao2 {
	
	public static void main(String[] args) {
		String s = "xabcabcabcabcdededededede";
		int answer = solution(s);
		System.out.println(answer);
	}
	public static int solution(String s) {
        int answer = 0;
        char[] ss = new char[s.length()];
        char first = s.charAt(0);
        for(int x=0; x<s.length(); x++) {
        	ss[x] = s.charAt(x);
        	if(ss[x]==first && x==0) {//첫번째 숫자만 같을때
        		answer = s.length();
        		return answer;
        	} else if(ss[x]==first){//같은숫자일때(첫번째X)
        		
        	} else {//틀린숫자일때
        		
        	}
        }//배열화
        
        
        
        return answer;
    }
}
