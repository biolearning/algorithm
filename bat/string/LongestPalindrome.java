package bat.string;

import java.util.Arrays;

public class LongestPalindrome {
	
    public String solution(String s) {
    	int N = s.length();
    	
    	//��#�����ʹ�ó���Ϊ(2N+1), һ��Ϊ����
        StringBuffer sb = new StringBuffer(N*2 + 1);
        sb.append("#");
        for(char ch : s.toCharArray()) {
        	sb.append(ch).append("#");
        }
        System.out.println(s);
        System.out.println(sb.toString());
        
        //����p���飬p�����Ԫ�ش����p��ʼ����������ҿ�����չ�ĸ���������p
        int[] p = new int[N*2 + 1];
        p[0] = 1;
        int id = 0,  mx = 1;
        int max = 0, index = 0;
        for (int i = 1; i < N*2 + 1; i++) {
        	if (mx > i) {
        		p[i] = Math.min(p[2*id - i], mx - i);        		
        	}else {
        		p[i] = 1;        		
        	}
        	for (; i + p[i] < 2*N + 1 && i - p[i] >= 0 && sb.charAt(i + p[i]) == sb.charAt(i - p[i]); p[i]++);
        	if (i + p[i] > mx) {
        		id = i;
        		mx = i + p[i];
        	}  	
        	
        	if (p[i] > max) {
        		max = p[i];
        		index = i;
        	}
        }
        System.out.println(Arrays.toString(p));
        return sb.substring(index - max + 1, index + max).replace("#", "");
    }

	public static void main(String[] args) {
		LongestPalindrome longestPalindrome = new LongestPalindrome();
		System.out.println("Longest: " + longestPalindrome.solution("bb"));
	}

}
