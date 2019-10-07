package programmers.test;

public class kakao3 {
	public static void main(String[] args) {
		String p ="()))((()";
		//()())(()
		//
		String answer = solution(p);
		System.out.println(answer);
	}
	public static String solution(String p) {
	       String answer = "";
	       StringBuffer pb = new StringBuffer(p);//string buffer·Î ¹Ù²Þ
	       int n = 0;
	       int flag=0;
	       
	       for(int x=0; x<pb.length(); x++) {
	    	   if(pb.charAt(x) == '(') {
	    		   n++;
	    	   }else {
	    		   n--;
	    		   if(n<0) {
	    			   for(int y=x+1; y<pb.length(); y++) {
    					   if(pb.charAt(y)=='(') {
    						   flag = y;
    						   break;
    					   }
    				   }
    				   
    				   pb.setCharAt(x, '(');
    				   pb.setCharAt(flag, ')');
    				   flag=0;
    				   n+=2;
    				   System.out.println(pb.toString());
	    		   }
	    	   }
	       }
	       answer = pb.toString();
	       return answer;
	}
}
