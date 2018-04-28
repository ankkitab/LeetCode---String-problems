/*
WORD BREAK (10ms)
Q. Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length()==0)
            return false;
        HashSet<String> newDict = new HashSet<>();
        for (int i=0;i<wordDict.size();i++) 
            newDict.add(wordDict.get(i));
        List<Integer> queue = new ArrayList<>();
        boolean visited[]= new boolean[s.length()+1];
        queue.add(0);
        visited[0]= true;
        while (!queue.isEmpty()) {
            int start=queue.get(0);
            if (start==s.length())
               return true;
            queue.remove(0);
            for (int i=start+1;i<=s.length();i++) {
                if (newDict.contains(s.substring(start,i))) {
                    if (visited[i])
                        break;
                    else {
                        queue.add(i);
                        visited[i]=true;
                    }
                }
            }
        }
        return false;
    }
}
