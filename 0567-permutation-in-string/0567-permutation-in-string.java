class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //for keeping track of frequency
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        if(s1.length() > s2.length()) return false;

        boolean ans = false;
        //intializing s1 count 
        for(char c: s1.toCharArray()){
            s1Count[c - 'a']++;
        }
        
        //using sliding window approach
        for(int i = 0; i < s2.length(); i++){
            s2Count[s2.charAt(i) - 'a']++;

            if(i >= s1.length()){
                s2Count[s2.charAt(i - s1.length()) - 'a' ]--;
            }

            //compare
            if(Arrays.equals(s1Count, s2Count)){
                return true;
            }
        }
        return false;
    }
}