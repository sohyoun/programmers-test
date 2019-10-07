package programmers.test;

import java.util.StringTokenizer;

/*
 * 이름@도메인이름.탑레멜도메인
 * 이름 : 영어 소문자 / .
 * 도메인 이름 : 영어소문자
 * 탑레벨도메인 : com/net/org
 * */
public class Naver_demo_1 {
	public static void main(String[] args) {
		String emails[] = {"d@co@m.com", "a@abc.com", "abc.def@x.com","abc","abc@defx","aaa@xx.net","@x.org","ff@.net","f.f.f.@f.f.net"};
		
		int result = solution(emails);
		
		System.out.println(result);
	}
	
	public static int solution(String emails[]) {
		//emails 길이 100000이하 email원소는 소문자,.,@로만 이루어진다.
		//@가 하나 인지 확인
		//.이 (길이-3)에 있는지 확인
		//마지막 . 뒤에 com,net,org인지 확인
		//@앞에 문자기 있는지
		//@와 . 사이에 문자가 있는지 !!!!!
		//@뒤에는 .이 하나만 있는지
		
		StringTokenizer st; //@로 자르는 토큰나이저
		StringTokenizer st2; // .로 자르는 토큰나이저
		int cnt = 0;
		int result = 0;
		int len = 0;//각 문자열의 길이
		String domain = "";//@뒤의 문자
		for(int x=0; x<emails.length; x++) {
			st = new StringTokenizer(emails[x], "@");
			cnt = st.countTokens();
			len = emails[x].length();
			if(cnt == 2) {//@가 하나 인지 확인
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
