/*
Longest Substring with At Most Two Distinct Characters (11ms)

Q. Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.

*/

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) { 
        if (s.length() == 0 || s==null) 
            return 0;
        int bytes[] = new int[53]; 
        int distinct = 0; 
        int  len = 0;
        int max= 0;  
        StringBuilder res = new StringBuilder();
        for (int i=0;i<s.length(); i++) {
            char ch = s.charAt(i); 
            int index; 
            if (ch>= 97 && ch <=122) 
                index = (int) ch - 'a'; 
            else 
                index = (int) (ch - 'A') + 26;
            if (bytes[index] == 0) { 
                distinct++; 
            }
            bytes[index]++; 
            len++; 
            res.append(ch); 
            if (distinct<=2) {
                max = Math.max(max,len) ;
                continue;
            }
            //delete from the begin whenever distinct crosses 2
            while (distinct>2) { 
                ch = res.charAt(0); 
                res.deleteCharAt(0);  
                if (ch >= 97 && ch <=122) 
                    index =(int) ch - 'a' ; 
                else 
                    index = (int) (ch - 'A') + 26;
                bytes[index]--;
                if (bytes[index] == 0) 
                    distinct --; 
                len--; 
            }
        }
        
        return max;  
    }
}
