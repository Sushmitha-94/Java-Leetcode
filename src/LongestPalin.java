/*
 * Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
 */
public class LongestPalin {
	
	/*
	 * public static String longPal(String input) { String palin =
	 * String.valueOf(input.charAt(0)); for(int i=0;i<input.length();i++) { for(int
	 * j=i+1 ; j<input.length()+1;j++ ) { String sub = input.substring(i, j);
	 * if(isPalindrome(sub) && palin.length()<sub.length()) { palin =
	 * input.substring(i, j); } } } return palin; }
	 * 
	 * public static Boolean isPalindrome(String str) { int j = str.length()-1;
	 * for(int i=0; i< str.length()/2 ; i++, j--) { if( str.charAt(i) !=
	 * str.charAt(j)) return false; } return true; }
	 */
	
	public static String longPal(String input) {	
		int len = input.length();
		//if(len<2)
			
			//return input;
		int[][] ind = new int[len][len];
		for(int i=0;i<len;i++) {
			ind[i][i] = 1;
			if(i< len-1 && input.charAt(i)==input.charAt(i+1)) {
				ind[i][i+1] = 1;
			}			
		}
		for(int i=2; i<len;i++) {
			for(int j=0; j<i-1; j++) {
				if(isPlaindrome(input,j,i,ind)) {
					ind[j][i] =1;
				}
			}			
		}
		
		for(int i=0;i<len;i++) {
			for(int j=len-1-i;j<len;j++) {
				if(ind[i][j]==1) {
					return input.substring(i,j+1);
				}
					
				
			}
			System.out.println();
		}
		return null;
	}
	
	public static Boolean isPlaindrome(String input,int start, int end, int[][] arr) {
		if(input.charAt(start) == input.charAt(end) && arr[start+1][end-1]==1)
			return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(longPal(("abb")));
		}

}
