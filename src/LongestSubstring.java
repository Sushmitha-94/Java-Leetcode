import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstring {

	// My method, using queue to save the passed through value and find max
	public static int lengthOfLongestSubstring(String s) {
		Queue<String> strQ = new LinkedList<String>();
		char[] strChar = s.toCharArray();
		int retLength=0;
		for(char c:strChar) {
			String str = String.valueOf(c);
			if(!strQ.contains(str)) {
				strQ.add(str);
			}
			else {
				retLength = Math.max(strQ.size(), retLength);
				
				while(strQ.size()>0 && !strQ.peek().equals(str)) {
						strQ.remove();
				}
				
				if(strQ.size()>0 && strQ.peek().equals(str)) {
					strQ.remove();
				}
				strQ.add(str);
			}
			
		}
		retLength = Math.max(strQ.size(), retLength);
        return retLength;
    }
	
	
	// Method: using string index instead of queue and use the same logic
	// its taking double the time than queue logic
	
	public static int lnOfLngstSubStr(String s) {
		int retLen=0, start=0, end=1, i=0;
		
		while(end<s.length()) {
			if(i==end) {
				retLen = Math.max(end-start+1, retLen);
				i=start;
				end++;
				continue;
			}
			while(i!=end) {
				if(s.charAt(i)==s.charAt(end)) {
					start=i+1;
				}
				i++;
			}
		}
		
        return retLen;
    }
	
	
	
	public static void main(String[] args) {
		String str="dvdf";
		System.out.println(lnOfLngstSubStr(str));
	}
}
