package programmers.test;

public class Kakao1 {
	public static void main(String[] args) {
		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
		
		int[] answer = solution(words,queries);
		System.out.println(answer[0]);
		
	}
	 public static int[] solution(String[] words, String[] queries) {
	        
	        
	        int sz = words.length;
	        int sz2 = queries.length;
	        
	        int[] answer = new int[sz2];
	        
	        String word="";
	        String query="";
	    
	        int count = 0;
	        int flag = 0;
	        
	        for(int y=0; y<sz2; y++){
	            query = queries[y];//fro??
	            for(int x=0; x<sz; x++){
	                word = words[x];//frodo
	                
	                if(word.length() == query.length()){
	                    for(int z=0; z<word.length(); z++){
	                        if(query.charAt(z) != '?'){
	                            if(word.charAt(z) == query.charAt(z)){
	                                flag += 1;
	                                System.out.println("jkjk");
	                            }
	                        } else{
	                            flag +=1;
	                        }
	                    }
	                }
	                if(flag == word.length()){
	                	System.out.println(query);
	                    count++;
	                }
	                flag = 0;
	            }
	            answer[y] = count;
	            count = 0;
	        }
	        
	        return answer;
	    }
}
