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
        	if(ss[x]==first && x==0) {//ù��° ���ڸ� ������
        		answer = s.length();
        		return answer;
        	} else if(ss[x]==first){//���������϶�(ù��°X)
        		
        	} else {//Ʋ�������϶�
        		
        	}
        }//�迭ȭ
        
        
        
        return answer;
    }
}
