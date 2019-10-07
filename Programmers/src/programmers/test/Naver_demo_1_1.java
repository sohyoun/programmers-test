package programmers.test;

//import java.util.regex.Pattern;
public class Naver_demo_1_1 {
	public static void main(String[] args) {
		String emails[] = {"d@co@m.com", "a@abc.com", "abc.def@x.com","abc","abc@defx","aaa@xx.net","@x.org","ff@.net","f.f.f.@f.f.net"};
		
		int result = solution(emails);
		
		System.out.println(result);
	}
	
	public static int solution(String emails[]) {
		int result = 0;
		for(int x=0; x<emails.length; x++) {
//			if(Pattern.matches("^[a-z.]+@[a-z]+\\.(com|net|org)$", emails[x])) {
//				result++;
//			}
			//둘중하나로 하면됨..!
			if(emails[x].matches("^[a-z.]+@[a-z]+\\.(com|net|org)$")) {
				result++;
			}
		}
		
		return result;
	}
}
