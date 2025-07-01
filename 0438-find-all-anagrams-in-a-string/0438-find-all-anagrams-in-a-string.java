class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //initialised two arrays for checking frequency
        int[] pcount = new int[26];
        int[] scount = new int[26];
        
        //result: where all starting index of anagrams are stored
        List<Integer> result = new ArrayList<>();

        //checking if s < p then return the empty list
        if(s.length() < 0 || s == null){
            return result;
        }
        //count frequency of characters in p
        for(char c : p.toCharArray()) {
            pcount[c - 'a']++;
        }
        //using the sliding window approach
        for(int i = 0; i<s.length(); i++){
            scount[s.charAt(i) - 'a']++;

            //removing the character out of the window
            if(i >= p.length()){
                scount[s.charAt(i - p.length()) -'a']--;
            }

            //compare the count
            if(Arrays.equals(pcount, scount)){
                result.add(i - p.length()+1);
            }
        }
    return result;
    }
}