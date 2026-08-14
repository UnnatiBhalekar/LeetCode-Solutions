class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0, maxlen = 0;
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            while(window.contains(c)){
                window.remove(s.charAt(left));
                left++;
            }
            window.add(c);
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }
}