package programmers.test;

public class kakao4 {
	public static void main(String[] args) {
		String s = "ababcdcdababcdcd";
		int answer = solution(s);
		System.out.println(answer);
	}
	public static int solution(String s) {
        int answer = 0;
        StringBuffer sb = new StringBuffer(s);
        int flag = 0;
        int y = 1;
        String f = "";
        int n =0;
        for(int x=1; x<sb.length(); x++) {
        	if(sb.charAt(0)!=sb.charAt(x)) {
        		answer=sb.length();
        		break;
        	}
        	else {
        		flag = x;//3
        		while(y==flag-1) {
        			if(sb.charAt(y)==sb.charAt(flag+y)) {
        				y++;
        			}
        		}
        		if(y==flag-1) {
        			f = sb.substring(0, y);
        			sb.replace(0, flag+y, f);
        			n++;
        		}
        	}
        }
        answer = n + sb.length();
        return answer;
    }
}
