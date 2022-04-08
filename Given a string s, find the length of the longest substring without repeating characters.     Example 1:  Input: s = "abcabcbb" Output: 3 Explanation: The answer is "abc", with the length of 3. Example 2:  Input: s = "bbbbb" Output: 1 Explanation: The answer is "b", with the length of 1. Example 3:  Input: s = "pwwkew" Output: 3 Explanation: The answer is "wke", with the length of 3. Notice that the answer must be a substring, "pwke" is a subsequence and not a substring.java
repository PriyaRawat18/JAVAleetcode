/*Given a string s, find the length of the longest substring without repeating characters.

 

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
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.*/




public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0;
        int charCount[] = new int[128];
        
        // For example s = "abcabcbb"
        // abstractly, after 3 iterations we will have symbols [a, b, c]
        for (int right = 0; right < s.length(); right++){
            charCount[s.charAt(right)]++;
            
            // When we encounter another character 'b' we remove all characters
            // from the left up to the first character 'b'
            // That is, we remove [a, b] and leave [c] in charCount
            while (charCount[s.charAt(right)] > 1) {
                charCount[s.charAt(left++)]--;                
            }
            result = Math.max(right - left + 1, result);
        }
        return result;
    }
