/* 
WORD SQUARES
Q. Given a set of words (without duplicates), find all word squares you can build from them.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.

b a l l
a r e a
l e a d
l a d y

*/

class Solution {
    HashMap<String,List<String> > map = new HashMap<>();  // prefix
    List<List<String>> res = new ArrayList<>(); 
    
    
    public List<List<String>> wordSquares(String[] words) {
        if (words==null || words.length==0) //base case
            return res;
        
        for (String str : words) {     
            for (int i=1;i<=str.length();i++) { //adding all the possible substrings
                String s = "";
                s += str.substring(0,i) ; 
                if (!map.containsKey(s)) {
                    map.put(s, new ArrayList<>()); 
                }
                map.get(s).add(str);
            }
        }
        
        for (String str : words) {
            boolean flag = false;
            for (int i=1;i<str.length();i++) 
                if (!map.containsKey(""+str.charAt(i))) {
                    flag = true;
                    break;
                }
            if (flag)
                continue; 
            List<String> row = new ArrayList<>(); 
            row.add(str);
            findSquare(str, 1, row);
        }
        
        return res;
    }
    
    public void findSquare (String first, int index, List<String> row) {
        if (index == first.length()) {
            //compare if correct 
                List<String> temp = new ArrayList<>(row);
                res.add(temp) ; 
            return; 
        }
       
        String s = "";
        for (int i=0;i<index;i++)
            s += row.get(i).charAt(index) ; 
        
        if (!map.containsKey(s))
            return;  
        
        List<String> options = map.get(s) ; 
        for (String op : options) {
           // System.out.println(op + " for main str= "+ first); 
            row.add(op) ; 
            findSquare(first, index+1, row) ; 
            row.remove(row.size()-1) ; 
        }
    }
}
