/*
PALINDROME PAIRS

Q. Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]

*/

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        int i=0;
        for (String word:words) 
            map.put(word, i++);
        
        for (i=0;i<words.length;i++) {
            String orig = words[i];
            for (int j = 0;j<=words[i].length(); j++ ) {
                String str1 = orig.substring(0,j); 
                String str2 = "";
                if (j!=words.length) 
                    str2 = orig.substring(j);
                StringBuilder temp; 
                List<Integer> pairs; 
                if (isPalindrome(str1)) {
                    temp = new StringBuilder(str2); 
                    temp.reverse(); 
                    if (temp.length()>=0 && map.containsKey(temp.toString()) && map.get(temp.toString())!=i) {
                        pairs = new ArrayList<>();
                        pairs.add(map.get(temp.toString()));
                        pairs.add(i);
                        res.add(pairs);
                    }
                }
                if (isPalindrome (str2)) {
                    temp = new StringBuilder(str1); 
                    temp.reverse(); 
                    if (map.containsKey(temp.toString()) && map.get(temp.toString())!=i && str2.length()!=0) {
                        pairs = new ArrayList<>();
                        pairs.add(i);
                        pairs.add(map.get(temp.toString()));
                        res.add(pairs);
                    }
                }
            }
        }
        
        
        return res;
    }
    
    public boolean isPalindrome(String s) {
        for (int i=0, j=s.length()-1 ; i<=j ;i++ , j--) 
            if (s.charAt(i)!=s.charAt(j))
                return false;
        return true;
    }
}
