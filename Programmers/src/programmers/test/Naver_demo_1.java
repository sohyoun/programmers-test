package programmers.test;

import java.util.StringTokenizer;

/*
 * �̸�@�������̸�.ž���ᵵ����
 * �̸� : ���� �ҹ��� / .
 * ������ �̸� : ����ҹ���
 * ž���������� : com/net/org
 * */
public class Naver_demo_1 {
	public static void main(String[] args) {
		String emails[] = {"d@co@m.com", "a@abc.com", "abc.def@x.com","abc","abc@defx","aaa@xx.net","@x.org","ff@.net","f.f.f.@f.f.net"};
		
		int result = solution(emails);
		
		System.out.println(result);
	}
	
	public static int solution(String emails[]) {
		//emails ���� 100000���� email���Ҵ� �ҹ���,.,@�θ� �̷������.
		//@�� �ϳ� ���� Ȯ��
		//.�� (����-3)�� �ִ��� Ȯ��
		//������ . �ڿ� com,net,org���� Ȯ��
		//@�տ� ���ڱ� �ִ���
		//@�� . ���̿� ���ڰ� �ִ��� !!!!!
		//@�ڿ��� .�� �ϳ��� �ִ���
		
		StringTokenizer st; //@�� �ڸ��� ��ū������
		StringTokenizer st2; // .�� �ڸ��� ��ū������
		int cnt = 0;
		int result = 0;
		int len = 0;//�� ���ڿ��� ����
		String domain = "";//@���� ����
		for(int x=0; x<emails.length; x++) {
			st = new StringTokenizer(emails[x], "@");
			cnt = st.countTokens();
			len = emails[x].length();
			if(cnt == 2) {//@�� �ϳ� ���� Ȯ��
				if(emails[x].lastIndexOf(".") == len-4) {
					if(emails[x].substring(len-3).equals("com") || emails[x].substring(len-3).equals("net") || emails[x].substring(len-3).equals("org")) {
						domain = st.nextToken();
						domain = st.nextToken();
						//System.out.println(domain);
						if(!domain.startsWith(".")) {
							st2 = new StringTokenizer(domain,".");
							if(st2.countTokens() ==2) {
								result ++;								
							}
						}
					}
				}
			}
			
			
		}
	
		return result;
	}
}
