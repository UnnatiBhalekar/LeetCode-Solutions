class Solution {
    public String reversePrefix(String word, char ch) {
        int n = word.length();
        int position = word.indexOf(ch);
        
        if(position == -1)
            return word;
        
        // String prefix = word.substring(0,position+1);
        // StringBuilder ans = new StringBuilder(prefix);
        // String finalAns = ans.reverse().toString();
        // return finalAns + word.substring(position+1);
        StringBuilder ans = new StringBuilder(word.substring(0,position+1));
        return ans.reverse().append(word.substring(position+1)).toString();
        
    }
}