package programmers.test;

import java.awt.List;
import java.util.Arrays;
import java.util.Collections;

public class kakao7 {
	public static void main(String[] args) {
		int n = 12;
		int[] weak = {1,3,4,9,10};
		int[] dist = {3,5,7};
		int answer = solution(n,weak,dist);
	}
	public static int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        int weaklen = weak.length-1;//4
        int[] z = new int[weaklen+1];
        for(int x=0; x<weaklen; x++) {
        	z[x] = weak[x+1] - weak[x];
        }
        
        int max2 = n-weak[weaklen]+weak[0];//3
        z[weaklen] = max2;
        
        //2,1,5,1,3
        
        //dist 3,5,7
//        Arrays.sort(z);//1,1,2,3,5
        List i = (List) Arrays.asList(z);
        
        
//        if(dist[dist.length-1]>Collections.max(i)) {
//        	for(int x=0; x<weaklen; x++) {
//        		
//        	}
//        }
        
        
        return answer;
    }
}
