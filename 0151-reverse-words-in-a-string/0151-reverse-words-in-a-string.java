class Solution {
    public String reverseWords(String s) {
        //splitting the input string on spaces
        String[ ] words = s.trim().split("\\s+");

        //using stringbuilder to store the string rev
        StringBuilder rev = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i --){
            rev.append(words[i]);
            if(i != 0){
                rev.append(" ");
            }
        }
    return rev.toString();
    }
}